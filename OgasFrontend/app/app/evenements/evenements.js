'use strict';

/* Controllers */

angular.module('evenements', ['ngTable']).
  config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/evenements', {templateUrl: 'app/evenements/evenements.html', controller: 'EvenementCtrl'});
  }]).
  controller('EvenementCtrl', ['$scope', 'ngTableParams', '$filter', function($scope, ngTableParams, $filter) {
          var data = [{name: "event1", date: "20/01/2013"},
                {name: "event2", date: "25/01/2013"},
                {name: "event3", date: "20/06/2014"},
                {name: "event4", date: "05/10/2012"},
                {name: "event5", date: "22/07/2015"},
                {name: "event6", date: "20/02/2013"},
                {name: "event7", date: "18/09/2013"},
                {name: "event8", date: "20/01/2016"}];

    $scope.tableParams = new ngTableParams({
        page: 1,            // show first page
        count: 5,           // count per page
        sorting: {
            date: 'asc'     // initial sorting
        }
    }, {
        total: data.length, // length of data
        getData: function($defer, params) {
             var orderedData = params.sorting() ?
                                $filter('orderBy')(data, params.orderBy()) :
                                data;
            
            $defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
        }
    });
  }]);
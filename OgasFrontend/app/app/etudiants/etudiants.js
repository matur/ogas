'use strict';

angular.module('etudiants', ['ngTable']).
  config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/etudiants', {templateUrl: 'app/etudiants/etudiants.html', controller: 'EtudiantCtrl'});
  }]).
  controller('EtudiantCtrl', ['$scope', 'ngTableParams', '$filter', function($scope, ngTableParams, $filter) {
          var data = [{name: "Moroni", age: 50},
                {name: "Tiancum", age: 43},
                {name: "Jacob", age: 27},
                {name: "Nephi", age: 29},
                {name: "Enos", age: 34},
                {name: "Tiancum", age: 43},
                {name: "Jacob", age: 27},
                {name: "Nephi", age: 29},
                {name: "Enos", age: 34},
                {name: "Tiancum", age: 43},
                {name: "Jacob", age: 27},
                {name: "Nephi", age: 29},
                {name: "Enos", age: 34},
                {name: "Tiancum", age: 43},
                {name: "Jacob", age: 27},
                {name: "Nephi", age: 29},
                {name: "Enos", age: 34}];

    $scope.tableParams = new ngTableParams({
        page: 1,            // show first page
        count: 5,           // count per page
        sorting: {
            name: 'asc'     // initial sorting
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
    
    $scope.etuAddAlert = function() {
            $scope.addAlert('danger', 'etudiants danger');
          };
  }]);
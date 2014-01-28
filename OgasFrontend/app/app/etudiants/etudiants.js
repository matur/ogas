'use strict';

angular.module('etudiants', ['ngTable']).
  config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/etudiants', {templateUrl: 'app/etudiants/etudiants.html', controller: 'EtudiantCtrl'})
  $routeProvider.when('/editRow', {templateUrl: 'app/etudiants/editRow.html', controller: 'EtudiantCtrl'})
  ;
  }]).

  controller('EtudiantCtrl', ['$scope', '$filter','ngTableParams', function($scope, $filter, ngTableParams) {
          var data = [{
                        "id":1,
                        "annee":"2011-2014",
                        "lm":138661285100,
                        "ln":"Smith",
                        "fn":"John",
                        "dc":"CEO",
                        "em":"j.smith@company.com",
                        "ph":"617-321-4567",
                        "ac":true,
                        "dl":false
                    }
                    ,
                    {
                        "id":2,
                        "annee":"2012-2015",
                        "lm":138661285200,
                        "ln":"Taylor",
                        "fn":"Lisa",
                        "dc":"VP of Marketing",
                        "em":"l.taylor@company.com",
                        "ph":"617-522-5588",
                        "ac":true,
                        "dl":false
                    },
                    {
                        "id":3,
                        "annee":"2011-2014",
                        "lm":138661285300,
                        "ln":"Jones",
                        "fn":"James",
                        "dc":"VP of Sales",
                        "em":"j.jones@company.com",
                        "ph":"617-589-9977",
                        "ac":true,
                        "dl":false
                    },
                    {
                        "id":4,
                        "annee":"2011-2014",
                        "lm":138661285400,
                        "ln":"Wong",
                        "fn":"Paul",
                        "dc":"VP of Engineering",
                        "em":"p.wong@company.com",
                        "ph":"617-245-9785",
                        "ac":true,
                        "dl":false
                    },
                    {
                        "id":5,
                        "annee":"2012-2015",
                        "lm":138661285500,
                        "ln":"King",
                        "fn":"Alice",
                        "dc":"Architect",
                        "em":"a.king@company.com",
                        "ph":"617-244-1177",
                        "ac":true,
                        "dl":false
                    },
                    {
                        "id":6,
                        "annee":"2013-2016",
                        "lm":138661285600,
                        "ln":"Brown",
                        "fn":"Jan",
                        "dc":"Software Engineer",
                        "em":"j.brown@company.com",
                        "ph":"617-568-9863",
                        "ac":true,
                        "dl":false
                    },
                    {
                        "id":7,
                        "annee":"2011-2014",
                        "lm":138661285700,
                        "ln":"Garcia",
                        "fn":"Ami",
                        "dc":"Software Engineer",
                        "em":"a.garcia@company.com",
                        "ph":"617-327-9966",
                        "ac":true,
                        "dl":false
                    },
                    {
                        "id":8,
                        "annee":"2011-2014",
                        "lm":138661285800,
                        "ln":"Green",
                        "fn":"Jack",
                        "dc":"Software Engineer",
                        "em":"j.green@company.com",
                        "ph":"617-565-9966",
                        "ac":true,
                        "dl":false
                    },
                    {
                        "id":9,
                        "annee":"2011-2014",
                        "lm":138661285900,
                        "ln":"Liesen",
                        "fn":"Abraham",
                        "dc":"Plumber",
                        "em":"a.liesen@company.com",
                        "ph":"617-523-4468",
                        "ac":true,
                        "dl":false
                    },
                    {
                        "id":10,
                        "annee":"2013-2016",
                        "lm":138661286000,
                        "ln":"Bower",
                        "fn":"Angela",
                        "dc":"Product Manager",
                        "em":"a.bower@company.com",
                        "ph":"617-877-3434",
                        "ac":true,
                        "dl":false
                    },
                    {
                        "id":11,
                        "annee":"2013-2016",
                        "lm":138661286100,
                        "ln":"Davidoff",
                        "fn":"Fjodor",
                        "dc":"Database Admin",
                        "em":"f.davidoff@company.com",
                        "ph":"617-446-9999",
                        "ac":true,
                        "dl":false
                    },
                    {
                        "id":12,
                        "annee":"2012-2015",
                        "lm":138661286200,
                        "ln":"Vitrovic",
                        "fn":"Biljana",
                        "dc":"Director of Communications",
                        "em":"b.vitrovic@company.com",
                        "ph":"617-111-1111",
                        "ac":true,
                        "dl":false
                    },
                    {
                        "id":13,
                        "annee":"2013-2016",
                        "lm":138661286300,
                        "ln":"Valet",
                        "fn":"Guillaume",
                        "dc":"Software Engineer",
                        "em":"g.valet@company.com",
                        "ph":"617-565-4412",
                        "ac":true,
                        "dl":false
                    },
                    {
                        "id":14,
                        "annee":"2012-2015",
                        "lm":138661286400,
                        "ln":"Tran",
                        "fn":"Min",
                        "dc":"Gui Designer",
                        "em":"m.tran@company.com",
                        "ph":"617-866-2554",
                        "ac":true,
                        "dl":false
                    }];


    $scope.tableParams = new ngTableParams({
        page: 1,            // show first page

        count: 10,           // count per page
 
        sorting: {
            name: 'asc'     // initial sorting
        }

    }, {
        groupBy: 'annee',
        total: data.length, // length of data
        getData: function($defer, params) {

        // use build-in angular filter
            var filteredData = params.filter() ?
                    $filter('filter')(data, params.filter()) :
                    data;
            var orderedData = params.sorting() ?
                    $filter('orderBy')(filteredData, params.orderBy()) :
                    data;

            params.total(orderedData.length); // set total for recalc pagination
            if(params.total() < params.page() * params.count() && params.total() < (params.page() -1) * params.count()){
              params.page(1);
            }
            $defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));

            var orderedData = params.sorting() ?
                                $filter('orderBy')(data, params.orderBy()) :
                                data;
            
            $defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));

        }
    });

    $scope.editId = -1;

    $scope.setEditId =  function(pid) {
                $scope.editId = pid;
    };

    
    $scope.etuAddAlert = function() {
            $scope.addAlert('danger', 'etudiants danger');
          };

  }]);
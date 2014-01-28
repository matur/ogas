'use strict';

/* Controllers */

angular.module('salles', ['ngTable']).
        config(['$routeProvider', function($routeProvider) {
                $routeProvider.when('/salles', {templateUrl: 'app/salles/salles.html', controller: 'SalleCtrl'});
            }]).
        controller('SalleCtrl', ['$scope', 'ngTableParams', '$filter', '$modal', function($scope, ngTableParams, $filter, $modal) {
                $scope.data = [{name: "salle5", capacite: "20"},
                    {name: "salle1", capacite: "10"},
                    {name: "salle4", capacite: "30"},
                    {name: "salle3", capacite: "40"},
                    {name: "salle2", capacite: "15"}];

                // Table of the elements
                $scope.tableParams = new ngTableParams({
                    page: 1,
                    count: 5,
                    sorting: {
                        name: 'asc'
                    }
                }, {
                    total: $scope.data.length,
                    getData: function($defer, params) {
                        var filteredData = params.filter() ?
                                $filter('filter')($scope.data, params.filter()) :
                                $scope.data;
                        var orderedData = params.sorting() ?
                                $filter('orderBy')(filteredData, params.orderBy()) :
                                $scope.data;

                        $scope.data = orderedData;
                        params.total(orderedData.length); // set total for recalc pagination
                        if (params.total() < params.page() * params.count() && params.total() < (params.page() - 1) * params.count()) {
                            params.page(1);
                        }
                        $defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
                    }
                });

                // Modals for creation and update
                $scope.addSalle = function() {
                    var modalInstance = $modal.open({
                        templateUrl: 'app/core/modal.html',
                        controller: 'ModalInstanceCtrl',
                        resolve: {
                            title: function() { return 'Creation d\'une salle' },
                            url: function() { return 'app/salles/forms/create.html'}
                        }
                    });
                    modalInstance.result.then(function() {
                        //Refresh the table
                    }, function() {
                        //Flush the form ?
                    });
                };
                $scope.editSalle = function(salle) {
                    var modalInstance = $modal.open({
                        templateUrl: 'app/core/modal.html',
                        controller: 'ModalInstanceCtrl',
                        resolve: {
                            title: function() { return 'Edition de la salle ' + salle.name },
                            url: function() { return 'app/salles/forms/update.html' }
                        }
                    });
                };
            }]).
        controller('ModalInstanceCtrl', ['$scope', '$modalInstance', 'title', 'url', function($scope, $modalInstance, title, url) {
            $scope.title = title;
            $scope.url = url;
            $scope.ok = function() {
                $modalInstance.close();
            };
            $scope.cancel = function() {
                $modalInstance.dismiss('cancel');
            };
        }]);
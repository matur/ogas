'use strict';

angular.module('salles', ['ngTable']).
        config(['$routeProvider', function($routeProvider) {
                $routeProvider.when('/salles', {templateUrl: 'app/salles/salles.html', controller: 'SalleCtrl'});
            }]).
        controller('SalleCtrl', ['$scope', 'ngTableParams', '$modal', function($scope, ngTableParams, $modal) {
                var data = [
                    {name: "salle5", capacite: "20"},
                    {name: "salle1", capacite: "10"},
                    {name: "salle4", capacite: "30"},
                    {name: "salle3", capacite: "40"},
                    {name: "salle5", capacite: "20"},
                    {name: "salle1", capacite: "10"},
                    {name: "salle4", capacite: "30"},
                    {name: "salle3", capacite: "40"},
                    {name: "salle5", capacite: "20"},
                    {name: "salle1", capacite: "10"},
                    {name: "salle4", capacite: "30"},
                    {name: "salle3", capacite: "40"},
                    {name: "salle5", capacite: "20"},
                    {name: "salle1", capacite: "10"},
                    {name: "salle4", capacite: "30"},
                    {name: "salle3", capacite: "40"},
                    {name: "salle2", capacite: "15"}
                ];

                $scope.tableParams = new ngTableParams({
                    page: 1, // show first page
                    count: 10           // count per page
                }, {
                    total: data.length, // length of data
                    getData: function($defer, params) {
                        $defer.resolve(data.slice((params.page() - 1) * params.count(), params.page() * params.count()));
                    }
                });

                // Modals for creation and update
                $scope.addSalle = function() {
                    var modalInstance = $modal.open({
                        templateUrl: 'app/core/modal.html',
                        controller: 'ModalInstanceCtrl',
                        resolve: {
                            title: function() {
                                return 'Creation d\'une salle'
                            },
                            url: function() {
                                return 'app/salles/forms/create.html'
                            }
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
                            title: function() {
                                return 'Edition de la salle ' + salle.name
                            },
                            url: function() {
                                return 'app/salles/forms/update.html'
                            }
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
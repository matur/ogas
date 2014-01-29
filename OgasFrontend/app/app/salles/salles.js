'use strict';

angular.module('salles', ['resources.salles', 'ngTable']).
        config(['$routeProvider', function($routeProvider) {
                $routeProvider.when('/salles', {
                    templateUrl: 'app/salles/salles.html',
                    controller: 'SalleListCtrl'
                });
            }]).
        controller('SalleListCtrl', ['$scope', 'ngTableParams', '$modal', 'Salles', function($scope, ngTableParams, $modal, Salles) {
                $scope.tableParams = new ngTableParams({
                    page: 1, // show first page
                    count: 10 // count per page
                }, {
                    getData: function($defer, params) {
                        Salles.all(function(salles) {
                            params.total(salles.length);
                            $defer.resolve(salles.slice((params.page() - 1) * params.count(), params.page() * params.count()));
                        });

                    }
                });

                // CREATE
                $scope.addSalle = function() {
                    var modalInstance = $modal.open({
                        templateUrl: 'app/core/modal.html',
                        controller: 'SalleCreateCtrl',
                        resolve: {
                            title: function() {
                                return 'Creation d\'une salle'
                            },
                            template: function() {
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
                // READ
                $scope.showSalle = function(salleId) {
                    var modalInstance = $modal.open({
                        templateUrl: 'app/core/modal.html',
                        controller: 'SalleReadCtrl',
                        resolve: {
                            title: function() {
                                return 'Affichage d\'une salle';
                            },
                            url: function() {
                                return 'app/salles/salle.html';
                            },
                            salleId: function() {
                                return salleId;
                            }
                        }
                    });
                };
                // UPDATE
                $scope.editSalle = function(salleId) {
                    var modalInstance = $modal.open({
                        templateUrl: 'app/core/modal.html',
                        controller: 'SalleUpdateCtrl',
                        resolve: {
                            title: function() {
                                return 'Edition d\'une salle';
                            },
                            url: function() {
                                return 'app/salles/forms/update.html';
                            }
                        }
                    });
                };
                // DELETE
                $scope.deleteSalle = function(salleId) {
                    var modalInstance = $modal.open({
                        templateUrl: 'app/core/modal.html',
                        controller: 'SalleDeleteCtrl',
                        resolve: {
                            title: function() {
                                return 'Suppression d\'une salle';
                            },
                            url: function() {
                                return 'app/salles/forms/delete.html'
                            }
                        }
                    });
                };
            }]).
        controller('SalleCreateCtrl', ['$scope', '$modalInstance', 'title', 'template', function($scope, $modalInstance, title, template) {
                $scope.modal.title = title;
                $scope.modal.template = url;
                $scope.submitForm = function() {
                    if ($scope.userForm.$valid) {
                        alert('Profil enregistré');
                    }
                };
                $scope.ok = function() {
                    $modalInstance.close();
                };
                $scope.cancel = function() {
                    $modalInstance.dismiss('cancel');
                };
            }]).
        controller('SalleReadCtrl', ['$scope', '$modalInstance', 'title', 'template', 'Salles', 'salleId', function($scope, $modalInstance, title, template, Salles, salleId) {
                $scope.modal.title = title;
                $scope.modal.template = template;
                $scope.salle = Salles.show({id: salleId});
                $scope.ok = function() {
                    $modalInstance.close();
                };
                $scope.cancel = function() {
                    $modalInstance.dismiss('cancel');
                };
            }])
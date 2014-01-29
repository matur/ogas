'use strict';
angular.module('salles', ['resources.salles', 'ngTable']).
        config(['$routeProvider', function($routeProvider) {
                $routeProvider.when('/salles', {
                    templateUrl: 'app/salles/salles.html',
                    controller: 'SalleListCtrl'
                });
            }]).
        controller('SalleListCtrl', ['$scope', 'ngTableParams', '$modal', 'Salles', function($scope, ngTableParams, $modal, Salles) {
                var createOptions = {controller: 'SalleCreateCtrl', title: 'Création d\'une salle', template: 'app/salles/partials/create.html'},
                readOptions = {controller: 'SalleReadCtrl', title: 'Affichage d\'une salle', template: 'app/salles/partials/read.html'},
                updateOptions = {controller: 'SalleUpdateCtrl', title: 'Modification d\'une salle', template: 'app/salles/partials/update.html'},
                deleteOptions = {controller: 'SalleDeleteCtrl', title: 'Suppression d\'une salle', template: 'app/salles/partials/delete.html'},
                modalBaseOptions = {templateUrl: 'app/core/modal.html'};
                // NG-TABLE
                var salles = [{id: "1", libelle: "Salle 1", capacite: "20", localisation: "Etage 1"},
                    {id: "1", libelle: "Salle 1", capacite: "20", localisation: "Etage 1"},
                    {id: "1", libelle: "Salle 1", capacite: "20", localisation: "Etage 1"},
                    {id: "1", libelle: "Salle 1", capacite: "20", localisation: "Etage 1"}];
                $scope.tableParams = new ngTableParams({
                    page: 1,
                    count: 10
                }, {
                    getData: function($defer, params) {
                        params.total(salles.length);
                        $defer.resolve(salles.slice((params.page() - 1) * params.count(), params.page() * params.count()));
                        /*Salles.all(function(salles) {
                         params.total(salles.length);
                         $defer.resolve(salles.slice((params.page() - 1) * params.count(), params.page() * params.count()));
                         });*/
                    }
                });
                // CREATE
                $scope.create = function() {
                    console.log(createOptions.title);
                    var modalInstance = $modal.open(angular.extend(angular.copy(modalBaseOptions), {
                        controller: createOptions.controller,
                        resolve: {title: function() {
                                return createOptions.title;
                            }, template: function() {
                                return createOptions.template;
                            }}
                    }));
                };
                // READ
                $scope.read = function(id) {
                    var modalInstance = $modal.open(angular.extend(angular.copy(modalBaseOptions), {
                        controller: readOptions.controller,
                        resolve: {title: function() {
                                return readOptions.title;
                            }, template: function() {
                                return readOptions.template;
                            }, id: function() {
                                return id;
                            }
                        }
                    }));
                };
                // UPDATE
                $scope.update = function(id) {
                    var modalInstance = $modal.open(angular.extend(angular.copy(modalBaseOptions), {
                        controller: updateOptions.controller,
                        resolve: {title: function() {
                                return updateOptions.title;
                            }, template: function() {
                                return updateOptions.template;
                            }, id: function() {
                                return id;
                            }
                        }
                    }));
                };
                // DELETE
                $scope.delete = function(id) {
                    var modalInstance = $modal.open(angular.extend(angular.copy(modalBaseOptions), {
                        controller: deleteOptions.controller,
                        resolve: {title: function() {
                                return deleteOptions.title;
                            }, template: function() {
                                return deleteOptions.template;
                            }, id: function() {
                                return id;
                            }
                        }
                    }));
                };
            }]).
        controller('SalleCreateCtrl', ['$scope', '$modalInstance', 'title', 'template', function($scope, $modalInstance, title, template) {
                $scope.title = title;
                $scope.template = template;
                $scope.submit = function() {
                    // Fonction called on submit of the create form
                    // Modal's util function :
                    //$modalInstance.close();
                    //$modalInstance.dismiss('cancel');
                };
                $scope.cancel = function() { $modalInstance.dismiss('cancel'); };
            }]).
        controller('SalleReadCtrl', ['$scope', '$modalInstance', 'title', 'template', 'Salles', 'id', function($scope, $modalInstance, title, template, Salles, id) {
                $scope.title = title;
                $scope.template = template;
                $scope.salle = Salles.show({id: id});
            }]).
        controller('SalleUpdateCtrl', ['$scope', '$modalInstance', 'title', 'template', 'Salles', 'id', function($scope, $modalInstance, title, template, Salles, id) {
                $scope.title = title;
                $scope.template = template;
                $scope.salle = Salles.show({id: id});
                $scope.submit = function() {
                    // Fonction called on submit of the update form
                };
            }]).
        controller('SalleDeleteCtrl', ['$scope', '$modalInstance', 'title', 'template', 'Salles', 'id', function($scope, $modalInstance, title, template, Salles, id) {
                $scope.title = title;
                $scope.template = template;
                $scope.submit = function() {
                    // Fonction called on submit of the delete button
                };
            }]);
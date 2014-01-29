'use strict';

/* Controllers */


angular.module('evenements', ['resources.evenements','ngTable']).
        config(['$routeProvider', function($routeProvider) {
                $routeProvider.when('/evenements', {templateUrl: 'app/evenements/evenements_onglets.html', controller: 'GeneralCtrl'});
            }]).
        controller('GeneralCtrl', ['$scope', 'ngTableParams', '$filter','serviceSalles','serviceEtudiants','serviceEntreprises','serviceEvenements','Evenements', function($scope, ngTableParams, $filter, serviceSalles, serviceEtudiants,serviceEntreprises,serviceEvenements,Evenements) {
                              
                $scope.tabTitres = [
                    {title: "Général", content: '/OgasFrontend/app/evenements/evenements_general.html'},
                    {title: "Entreprises", content: "/OgasFrontend/app/evenements/evenements_entreprises.html"},
                    {title: "Etudiants", content: "/OgasFrontend/app/evenements/evenements_etudiants.html"},
                    {title: "Salles", content: "/OgasFrontend/app/evenements/evenements_salles.html"},
                    {title: "Voeux", content: "/OgasFrontend/app/evenements/evenements_voeux.html"},
                    {title: "Planning", content: "/OgasFrontend/app/evenements/planning.html"}
                ];
                Evenements.all(function(evenements){
                    $scope.tabEvenements = evenements;
                    $scope.selectionTabEvenements= $scope.tabEvenements[$scope.tabEvenements.length-1];
                });
                $scope.tabSalles = serviceSalles.query();
                $scope.tabEtudiants = serviceEtudiants.query();
                $scope.tabEntreprises = serviceEntreprises.query();
               }]);


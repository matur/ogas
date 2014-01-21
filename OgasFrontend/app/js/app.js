'use strict';


// Declare app level module which depends on filters, and services
angular.module('myApp', [
  'ngRoute',
  'myApp.filters',
  'myApp.services',
  'myApp.directives',
  'myApp.controllers'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/', {templateUrl: 'partials/home.html', controller: 'HomeController'});
  $routeProvider.when('/connexion', {templateUrl: 'partials/connexion.html', controller: 'ConnexionController'});
  $routeProvider.when('/etudiants', {templateUrl: 'partials/etudiants.html', controller: 'EtudiantController'});
  $routeProvider.when('/entreprises', {templateUrl: 'partials/entreprises.html', controller: 'EntrepriseController'});
  $routeProvider.when('/evenements', {templateUrl: 'partials/evenements.html', controller: 'EvenementController'});
  $routeProvider.when('/salles', {templateUrl: 'partials/salles.html', controller: 'SalleController'});
  $routeProvider.otherwise({redirectTo: '/'});
}]);

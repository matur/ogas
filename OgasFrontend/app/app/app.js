'use strict';


// Declare app level module which depends on filters, and services
angular.module('app', [
  'ngRoute',
  'ui.bootstrap',
  'dragAndDrop',
  'etudiants',
  'salles',
  'entreprises',
  'evenements'
  //,'editRow'
  /*,

  'entreprises',
  'evenements'/*,

  'salles',
  */
]).
config(['$routeProvider', function($routeProvider) {
  /*$routeProvider.when('/', {templateUrl: 'partials/home.html', controller: 'HomeController'});
  $routeProvider.when('/connexion', {templateUrl: 'partials/connexion.html', controller: 'ConnexionController'});
  $routeProvider.when('/etudiants', {templateUrl: 'partials/etudiants.html', controller: 'EtudiantController'});
  $routeProvider.when('/entreprises', {templateUrl: 'partials/entreprises.html', controller: 'EntrepriseController'});
  $routeProvider.when('/evenements', {templateUrl: 'partials/evenements.html', controller: 'EvenementController'});
  $routeProvider.when('/salles', {templateUrl: 'partials/salles.html', controller: 'SalleController'});*/
  $routeProvider.otherwise({redirectTo: '/'});
}]).
  controller('HomeCtrl', ['$scope', function($scope){
          /*
           * Controller global a l'application -> methodes 
           */
        $scope.alerts = [];

          $scope.addAlert = function(type, msg) {
            $scope.alerts.push({type: type, msg: msg});
          };

          $scope.closeAlert = function(index) {
            $scope.alerts.splice(index, 1);
          };
}]);
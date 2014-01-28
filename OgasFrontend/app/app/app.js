'use strict';


// Declare app level module which depends on filters, and services
angular.module('app', [
  'ngRoute',
  'ui.bootstrap',
  'dragAndDrop',
  'etudiants',
  'entreprises',
  'evenements',
  'salles'
]).
config(['$routeProvider', function($routeProvider) {
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

'use strict';

/* Controllers */

angular.module('monprofil', []).
  config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/monprofil', {templateUrl: 'app/authentification/monprofil.html', controller: 'MonProfilCtrl'});
  }])
    .controller('MonProfilCtrl', ['$scope', function($scope){
            
	$scope.submitForm = function() {

		// check to make sure the form is completely valid
		if ($scope.userForm.$valid) {
			alert('Profil enregistré');
		}

	};

            
    }]);
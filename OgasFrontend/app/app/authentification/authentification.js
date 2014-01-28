/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module('authentification', [])
    .controller('AuthentificationCtrl', ['$scope', function($scope){
            
            $scope.authenticate = function(){
                console.log("login : "+$scope.loginId);
                console.log("mdp : "+$scope.loginMdp);
                
            }
    }]);



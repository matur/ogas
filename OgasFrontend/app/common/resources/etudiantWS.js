/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * client webservice pour les etudiants
 * ------------------------------------
 * 
 */

var etudiantWS = angular.module('etudiantWS', [
	"ngResource"
]);

etudiantWS.factory("etudiantWS", ["$resource",function($resource){
        this.wsBaseUrl = 'http://134.214.119.156:9000/OgasBackend/ws/etudiant/';
        this.wsResources = [];
        
        /*
         * this.wsResources["getAllSalles"] = $resource(this.wsBaseUrl+'findAll');
         * this.wsResources["getSalle"] = $resource(this.wsBaseUrl+'find/:id');
         */

       return this;
}]);
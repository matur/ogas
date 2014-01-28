/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * client webservice pour les salles
 * ---------------------------------
 * salleWS['getAllSalles']
 *      parametres : aucun
 *      
 * salleWS['getSalle']
 *      parametres : [number] id
 */

var salleWS = angular.module('salleWS', [
	"ngResource"
]);

salleWS.factory("salleWS", ["$resource",function($resource){
        this.wsBaseUrl = 'http://134.214.119.156:9000/OgasBackend/ws/salle/';
        this.wsResources = [];
        
        // quand on s'attend a recevoir un array (par exemple), il faut le preciser
        this.wsResources["getAllSalles"] = $resource(this.wsBaseUrl+'findAll', {}, {'get':{method:'GET', isArray:true}});
        
        this.wsResources["getSalle"] = $resource(this.wsBaseUrl+'find/:id');

       return this;
}]);
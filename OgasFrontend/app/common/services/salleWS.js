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
        this.wsBaseUrl = 'http://134.214.119.156:9000/OgasBackend/ws/';

       return $resource(this.wsBaseUrl+'salles/:id', {id:''}, {
            getAll: { method: 'GET', isArray: true },
            create: { method: 'POST' },
            show: { method: 'GET' },
            update: { method: 'PUT', params: {id: '@id'} },
            delete: { method: 'DELETE', params: {id: '@id'} }
        });
}]);
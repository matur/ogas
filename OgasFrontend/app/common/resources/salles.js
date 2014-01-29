angular.module('resources.salles', ["ngResource"])
    .factory("Salles", ["$resource", function($resource) {
        this.baseUrl = 'http://134.214.119.156:9000/OgasBackend/ws/';
        return $resource(this.baseUrl + 'salles/:id', {id: ''}, {
            all: {method: 'GET', isArray: true},
            create: {method: 'POST'},
            show: {method: 'GET'},
            update: {method: 'PUT', params: {id: '@id'}},
            delete: {method: 'DELETE', params: {id: '@id'}}
        });
}]);
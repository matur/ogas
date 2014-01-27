'use strict';

/* Controllers */

angular.module('salles', ['ngTable']).
  config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/salles', {templateUrl: 'app/salles/salles.html', controller: 'SalleCtrl'});
  }]).
  controller('SalleCtrl', ['$scope', 'ngTableParams', '$filter', '$modal', function($scope, ngTableParams, $filter, $modal) {
   $scope.data = [{name: "salle5", capacite: "20"},
                {name: "salle1", capacite: "10"},
                {name: "salle4", capacite: "30"},
                {name: "salle3", capacite: "40"},
                {name: "salle2", capacite: "15"}];

    $scope.tableParams = new ngTableParams({
        page: 1,            // show first page
        count: 5,           // count per page
        sorting: {
            name: 'asc'     // initial sorting
        }
    }, {
        total: $scope.data.length, // length of data
        getData: function($defer, params) {
            var filteredData = params.filter() ?
                    $filter('filter')($scope.data, params.filter()) :
                    $scope.data;
             var orderedData = params.sorting() ?
                                $filter('orderBy')(filteredData, params.orderBy()) :
                                $scope.data;
             
             $scope.data = orderedData;
             
             params.total(orderedData.length); // set total for recalc pagination
             if(params.total() < params.page() * params.count() && params.total() < (params.page() -1) * params.count()){
              params.page(1);
            }
            
            $defer.resolve(orderedData.slice((params.page() - 1) * params.count(), params.page() * params.count()));
        } 
    });
    
    // popup
    $scope.modalInstance = null;
    $scope.salleSelected = null;
    $scope.popupMode = "Voir"; // view, create or update
    
    $scope.isViewMode = function(){
        return ($scope.popupMode == "Voir");
    }
    
    $scope.viewOK = function(){
        $scope.modalInstance.close();
    }
    
    $scope.viewPopup = function(index){
        $scope.salleSelected = $scope.data[index];
        $scope.popupMode = "Voir";
        $scope.viewMode = true;
        
        $scope.modalInstance = $modal.open({
            templateUrl: "app/salles/popupCRUsalle.html",
            scope: $scope
          });

          $scope.modalInstance.result.then(function () {
              // quand la popup est fermee normalement
              $scope.salleSelected = null;
              $scope.modalInstance = null;
              $scope.addAlert("success","Vous avez clique sur ok");
          }, function () {
              // quand la popup est 'dismissed' (on annule ou on clique en-dehors)
            console.log('Modal dismissed at: ' + new Date());
            $scope.salleSelected = null;
            $scope.modalInstance = null;
            $scope.addAlert("danger","Vous avez clique sur cancel");
          });
      }
  }]);
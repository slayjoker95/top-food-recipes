var servicesModule = angular.module('topFoodRecipeAppServices', ['ui.grid','ui.grid.pagination']);

servicesModule.service('CuisineService', function($http, SERVER_URL) {
    this.getCuisines = function() {
        return $http.get(SERVER_URL+'api/cuisine')
            .then(function(response){
            return response.data;
        }).catch(function(err) {
            return [];
        });
    }

    this.addNewCuisine = function(cuisine) {
        console.log("posting data....");
        return $http.post(SERVER_URL+'api/cuisine', JSON.stringify(cuisine)).success(function(){
            console.log("success");
        });
    }
});
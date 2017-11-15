const myApp = angular.module('topFoodRecipesApp', ["ngRoute"])
    .config(function($routeProvider){
    	$routeProvider.when('/recipes', {
    		templateUrl:'views/recipes.html',
    		controller:'RecipeController'
    	}).when('/cuisines', {
    		templateUrl:'views/cuisines.html',
    		controller:'CuisineController'
    	}).when('/ingredients', {
    		templateUrl:'views/ingredients.html',
			controller:'IngredientController'
		});
})
    .constant('SERVER_URL', 'http://http://188.166.30.145:8080/top_food_recipes-0.0.1-SNAPSHOT/');
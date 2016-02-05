var app = angular.module('shareNotes');
app.controller('buscarPostCategoriaCtrl', function($scope, $http, $location) {
	
	$http.get("http://localhost:8080/ShareNotesAngularRest/rest/ServicioCategorias/listarCategorias")
    .success(function(data) {
        $scope.categorias = data;          
     });
	
	$http.get("http://localhost:8080/ShareNotesAngularRest/rest/ServicioPost/post?id="+$location.search().id)
    .success(function(data) {
        $scope.post = data;
     });
	
	   $scope.buscarPost = function(a) {
   		$http.get("http://localhost:8080/ShareNotesAngularRest/rest/ServicioPost/buscarPostTitulo/"+a)
    	    .success(function(data) {
    	        $scope.posts = data;   
    	     });
	   }
	   
});
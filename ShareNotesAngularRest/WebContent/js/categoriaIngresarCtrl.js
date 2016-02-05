var app = angular.module('shareNotes', []);

app.controller('categoriaIngresarCtrl', function($scope, $http,  $window) {
	
   $scope.ingresarCategoria = function(a) {
      		$http.get("http://localhost:8080/ShareNotesAngularRest/rest/ServicioCategorias/ingresarCategoria/"+a)
       	    .success(function(data) {
       	    	$scope.vaciarInputs();
       	    	$window.alert("Categoria Ingresada Correctamente :) "); 
       	        $scope.categoria = data;          
       	     });
   };
   
   $scope.vaciarInputs = function() {    	
   $scope.ct={
   		nombrecategoria: " "
   		   };
   	angular.copy($scope.ct, $scope.categoria);       
   }
    
   
   $scope.eliminarCategoria=function (a){
	   $http.get("http://localhost:8080/ShareNotesAngularRest/rest/ServicioCategorias/eliminarCategoria/"+a)
	   .success(function(data){
		   $scope.eliminarCat = data;
		   $window.alert("Categoria Eliminada Exitosamenta :( "); 
	   });
   }
   
   $http.get("http://localhost:8080/ShareNotesAngularRest/rest/ServicioCategorias/listarCategorias")
   .success(function(data) {
       $scope.categorias = data;          
    });
   
   //editar categoria
   $scope.actualizarCategoria = function(a, b) {
  		$http.get("http://localhost:8080/ShareNotesAngularRest/rest/ServicioCategorias/editarCategoria/"+a +"/"+b)
   	    .success(function(data) {   	    
   	        $scope.categoriaEditar = data;   
   	        $window.alert("Categoria Actualizada Existosamente :) "); 
   	     });
	   }
   
   
   
   
});
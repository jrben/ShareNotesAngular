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
    
});
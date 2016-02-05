var app = angular.module('shareNotes', []);

app.controller('ingresarUsuarioCtrl', function($scope, $http, $window) {
	
   $scope.ingresarUsuario = function(a,b,c,d) {
      		$http.get("http://localhost:8080/ShareNotesAngularRest/rest/ServicioUsuario/ingresarUsuario/"+a
      				+"/"+b+"/"+c+"/"+d)
       	    .success(function(data) {
       	    	$scope.vaciarInputs();
       	        $scope.posts = data;    
       	     $window.alert("Usuario Ingresada Correctamente :) "); 
       	     });
   };
   
   $scope.vaciarInputs = function() {    	
   $scope.usr={
   		nombre: "",
   		username: "",
   		password1: "",
   		password2: ""
   };
   	angular.copy($scope.usr, $scope.usuario);       
   }
    
});


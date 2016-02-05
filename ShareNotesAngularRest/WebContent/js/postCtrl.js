var app = angular.module('shareNotes', ['ngRoute'])
.config(function($locationProvider) {	
	$locationProvider.html5Mode({
		  enabled: true,
		  requireBase: false
		});
	});

app.controller('postCtrl1', function($scope, $http) {
		$http.get("http://localhost:8080/ShareNotesAngularRest/rest/ServicioPost/listarPosts")
	    .success(function(data) {
	        $scope.posts = data;          
	     });
});

app.controller('verPostCtrl', function($scope, $http, $location) {
	
	$http.get("http://localhost:8080/ShareNotesAngularRest/rest/ServicioPost/post?id="+$location.search().id)
    .success(function(data) {
        $scope.posts = data;          
     });
	
	 $scope.eliminarPost = function(a) {
    		$http.get("http://localhost:8080/ShareNotesAngularRest/rest/ServicioPost/eliminarPost/"+a)
     	    .success(function(data) {
     	        $scope.rpta = data;          
     	     });
	 }
	 
	
});


app.controller('editarPostCtrl', function($scope, $http, $location) {
	
	$http.get("http://localhost:8080/ShareNotesAngularRest/rest/ServicioCategorias/listarCategorias")
    .success(function(data) {
        $scope.categorias = data;          
     });
	
	$http.get("http://localhost:8080/ShareNotesAngularRest/rest/ServicioPost/post?id="+$location.search().id)
    .success(function(data) {
        $scope.post = data;
     });
	
	   $scope.actualizarPost = function(a,b,c,d) {
   		$http.get("http://localhost:8080/ShareNotesAngularRest/rest/ServicioPost/actualizarPost/"+a
   				+"/"+b+"/"+c+"/"+d)
    	    .success(function(data) {
    	    	$scope.vaciarInputs();
    	        $scope.posts = data;          
    	     });
	   }
	   
	   $scope.vaciarInputs = function() {    	
		   $scope.p={
				titulo: "",
				categoria: "",
				descripcion: ""
		   };
		   	angular.copy($scope.p, $scope.post);       
	 }
	
});

app.controller('nuevoPostCtrl', function($scope, $http) {
	
	$http.get("http://localhost:8080/ShareNotesAngularRest/rest/ServicioCategorias/listarCategorias")
    .success(function(data) {
        $scope.categorias = data;          
     });
	
	
	   $scope.ingresarPost = function(a,b,c) {
     		$http.get("http://localhost:8080/ShareNotesAngularRest/rest/ServicioPost/ingresarPost/"+a
     				+"/"+b+"/"+c)
      	    .success(function(data) {
      	    	$scope.vaciarInputs();
      	        $scope.posts = data;          
      	     });
	   }
	   
	   $scope.vaciarInputs = function() {    	
		   $scope.p={
				titulo: "",
				categoria: "",
				descripcion: ""
		   };
		   	angular.copy($scope.p, $scope.post);       
	 }
	
	
});
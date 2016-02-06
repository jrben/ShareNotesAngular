var app = angular.module('shareNotes',['ngRoute'])
.config(function($locationProvider) {	
	$locationProvider.html5Mode({
		  enabled: true,
		  requireBase: false
		});
	});


app.controller('postsPorCategoriaTituloCtrl', function($scope, $http, $location) 
		{
	
	$http.get("http://localhost:8080/ShareNotesAngularRest/rest/ServicioPost/listarPostsPorCategoria?id="+$location.search().id)
    .success(function(data) {
        $scope.postsPorCategoria = data;          
     });
	
	
});


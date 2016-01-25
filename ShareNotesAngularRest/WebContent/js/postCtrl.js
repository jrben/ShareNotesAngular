var app = angular.module('shareNotes', ['ngRoute'])
.config(function($locationProvider) {	
	$locationProvider.html5Mode({
		  enabled: true,
		  requireBase: false
		});
	});

app.controller('postCtrl', function($scope, $http) {
		$http.get("http://localhost:8080/ShareNotesAngularRest/rest/ServicioPost/listarPosts")
	    .success(function(data) {
	        $scope.posts = data;          
	     });
});

app.controller('verPostCtrl',
	function($scope, $http, $location) {
	$http.get("http://localhost:8080/ShareNotesAngularRest/rest/ServicioPost/post?id="+$location.search().id)
    .success(function(data) {
        $scope.posts = data;          
     });
});

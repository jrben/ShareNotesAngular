var app = angular.module('shareNotes', [])


app.controller('categoriaCtrl', function($scope, $http) 
		{
	$http.get("http://localhost:8080/ShareNotesAngularRest/rest/ServicioCategorias/listarCategorias")
    .success(function(data) {
        $scope.categoria = data; 
       
    });
});


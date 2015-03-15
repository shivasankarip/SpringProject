var puzzlesApp = angular.module('puzzlesApp', []);

puzzlesApp.controller('searchController', function($scope, $http) {
	$scope.searchResult = [];

	$scope.search = function() {
		//remove current results
		$scope.searchResult = [];
		$scope.messageText="";
		
		//search
		$http.get('/puzzles-core/rest/search',		
			{params: {
				searchText:$scope.searchText}})
			.success(function(data, status) {
				$scope.httpStatus = status;
				$scope.httpData = data;
				$scope.errorStatus=false;
				$scope.messageText="Found "+data.length;
				$scope.searchResult= data;
			})
			.error(function(data, status) {
				$scope.httpStatus = status;				
				$scope.httpData = data;
				$scope.errorStatus=true;
				$scope.messageText=data.error.code+ " "+ data.error.message;
			});		
	};
});

puzzlesApp.controller('puzzlesAddUserController', function($scope, $http) {	
	
	$scope.create = function() {
		$scope.messageText="";
		
		$http.post('/puzzles-core/rest/users',
				{"user":{"firstName":$scope.createFirstName,"lastName":$scope.createLastName,"emailId":$scope.createEmailId,"password":$scope.createPassword,"phone":$scope.createPhone}})
			.success(function(data, status) {
				$scope.httpStatus = status;
				$scope.httpData = data;
				$scope.errorStatus=false;
				$scope.messageText="Created new user with ID "+data.user.userId;				
			})
			.error(function(data, status) {
				$scope.httpStatus = status;				
				$scope.httpData = data;
				$scope.errorStatus=true;
				$scope.messageText=data.error.code+ " "+ data.error.message;
			});
	};
});
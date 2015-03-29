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
				//alert(JSON.stringify(data));
				$scope.httpStatus = status;
				$scope.httpData = data;
				$scope.errorStatus=false;
				$scope.messageText="Found ";
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

puzzlesApp.controller('puzzlesMovieController', function($scope, $http) {	
	
	$scope.getNowPlaying = function() {
		$scope.messageText="";
		
		$http.get('/puzzles-core/rest/movies/currentMovies',
				{params: {
					searchText:$scope.searchText}})
				.success(function(data, status) {
					//alert(JSON.stringify(data));
					$scope.httpStatus = status;
					$scope.httpData = data;
					$scope.errorStatus=false;
					$scope.messageText="Found ";
					$scope.movieResult= data;
					$scope.movieWeekResult=false;
					$scope.movieSoonResult=false;
			        
				})
				.error(function(data, status) {
					$scope.httpStatus = status;				
					$scope.httpData = data;
					$scope.errorStatus=true;
					$scope.messageText=data.error.code+ " "+ data.error.message;
				});		
		};
		
		$scope.getThisWeek = function() {
			$scope.messageText="";
			
			$http.get('/puzzles-core/rest/movies/upComingMovies',
					{params: {
						searchText:$scope.searchText}})
					.success(function(data, status) {
						//alert(JSON.stringify(data));
						$scope.httpStatus = status;
						$scope.httpData = data;
						$scope.errorStatus=false;
						$scope.messageText="Found ";
						$scope.movieWeekResult= data;
						$scope.movieSoonResult=false;
						$scope.movieResult=false;

				        
					})
					.error(function(data, status) {
						$scope.httpStatus = status;				
						$scope.httpData = data;
						$scope.errorStatus=true;
						$scope.messageText=data.error.code+ " "+ data.error.message;
					});		
			};
			
			$scope.comingSoon = function() {
				$scope.messageText="";
				
				$http.get('/puzzles-core/rest/movies/comingSoonMovies',
						{params: {
							searchText:$scope.searchText}})
						.success(function(data, status) {
							//alert(JSON.stringify(data));
							$scope.httpStatus = status;
							$scope.httpData = data;
							$scope.errorStatus=false;
							$scope.messageText="Found ";
							$scope.movieSoonResult= data;
							$scope.movieWeekResult=false;
							$scope.movieResult=false;
					        
						})
						.error(function(data, status) {
							$scope.httpStatus = status;				
							$scope.httpData = data;
							$scope.errorStatus=true;
							$scope.messageText=data.error.code+ " "+ data.error.message;
						});		
				};

});


puzzlesApp.controller('movieDetailsController', function($scope, $http) {
	$scope.searchResult = [];
	
	$scope.movieDetail = function(movieId) {
		//remove current results
		$scope.searchResult = [];
		$scope.messageText="";
		
		//search
		$http.get('/puzzles-core/rest/movies',		
			{params: {
				movieId:movieId}})
			.success(function(data, status) {
				alert(JSON.stringify(data));
				$scope.httpStatus = status;
				$scope.httpData = data;
				$scope.errorStatus=false;
				$scope.messageText="Found ";
				$scope.movieDetailResult= data;
				
		        
			})
			.error(function(data, status) {
				$scope.httpStatus = status;				
				$scope.httpData = data;
				$scope.errorStatus=true;
				$scope.messageText=data.error.code+ " "+ data.error.message;
			});		
	};
});




var puzzlesApp = angular.module('puzzlesApp', []);

puzzlesApp.filter('range', function() {
	  return function(input, start, end) {    
		    start = parseInt(start);
		    end = parseInt(end);
		    var direction = (start <= end) ? 1 : -1;
		    while (start != end) {
		        input.push(start);
		        start += direction;
		    }
		    return input;
		  };
		});

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
	
	
	$scope.movieDetail = function(movieId) {
		
		$http.get('/puzzles-core/rest/show',		
			{params: {
				movieId:movieId}})
			.success(function(data, status) {
				//alert(JSON.stringify(data));
				$scope.httpStatus = status;
				$scope.httpData = data;
				$scope.errorStatus=false;
				$scope.messageText="Found ";
				$scope.movieDetailResult= data;
				details(movieId);
		        
			})
			.error(function(data, status) {
				$scope.httpStatus = status;				
				$scope.httpData = data;
				$scope.errorStatus=true;
				$scope.messageText=data.error.code+ " "+ data.error.message;
			});		
	};
	
$scope.theaterDetail = function(theaterId) {
		
		$http.get('/puzzles-core/rest/show/theater',		
			{params: {
				theaterId:theaterId}})
			.success(function(data, status) {
				//alert(JSON.stringify(data));
				$scope.httpStatus = status;
				$scope.httpData = data;
				$scope.errorStatus=false;
				$scope.messageText="Found ";
				$scope.theaterDetailResult= data;
				
		        
			})
			.error(function(data, status) {
				$scope.httpStatus = status;				
				$scope.httpData = data;
				$scope.errorStatus=true;
				$scope.messageText=data.error.code+ " "+ data.error.message;
			});		
	};
	
$scope.details = function(movieId) {
		
		$http.get('/puzzles-core/rest/movies',		
			{params: {
				movieId:movieId}})
			.success(function(data, status) {
				//alert(JSON.stringify(data));
				$scope.httpStatus = status;
				$scope.httpData = data;
				$scope.errorStatus=false;
				$scope.messageText="Found ";
				$scope.detailResult= data;
				/*$scope.tryIt=function(data){
					
					
				}*/
		        
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

/*puzzlesApp.controller('puzzlesMovieController', function($scope, $http) {	
	
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
*/

/*puzzlesApp.controller('movieDetailsController', function($scope, $http) {
	$scope.searchResult = [];
	
	$scope.movieDetail = function(movieId) {
		//remove current results
		$scope.searchResult = [];
		$scope.messageText="";
		
		//search
		$http.get('/puzzles-core/rest/show',		
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
});*/




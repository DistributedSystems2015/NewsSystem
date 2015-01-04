function newsController($scope, $routeParams, baseServiceUrl, $http) {
    var id = $routeParams['id'];
    $scope.title = 'News ' + id;

    var currentNewsUrl = baseServiceUrl + 'api/news/'+id;
    $scope.currentNews = {};

    $http.get(currentNewsUrl).then(
        function (res) {
            $scope.currentNews = res.data;
        }
    )
}
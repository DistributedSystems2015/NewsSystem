function newsListController($scope, $http, baseServiceUrl) {
    $scope.title = 'News list';

    var allNewsUrl = baseServiceUrl + 'api/news';
    $scope.allNews = [];

    $http.get(allNewsUrl).then(
        function (res) {
            $scope.allNews = res.data;
        }
    )
}
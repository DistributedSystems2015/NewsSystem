function weatherController($scope, weatherService) {
    var promise = weatherService.getWeather();
    promise.then(function (item) {
        $scope.icon = item.icon;
        $scope.deg = item.deg;
    });
}
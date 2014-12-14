function newsController($scope, $routeParams) {
    var id = $routeParams['id'];
    $scope.title = 'News ' + id;
}
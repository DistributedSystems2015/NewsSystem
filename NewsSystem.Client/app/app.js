var app = angular.module("newsSystem", ['ngRoute'])
    .controller('newsController', newsController)
    .controller('newsListController', newsListController)
    .config(function($routeProvider) {
        $routeProvider
            .when('/news', {
                templateUrl: 'app/views/newsList.html',
                controller: 'newsListController'
            })
            .when('/news/:id', {
                templateUrl: 'app/views/news.html',
                controller: 'newsController',
            })
            .otherwise({ redirectTo: '/news' });
    });
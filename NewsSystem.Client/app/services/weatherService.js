function weatherService($http, $q) {
    var baseImageUrl = 'http://openweathermap.org/img/w/';
    var apiUrl = 'http://api.openweathermap.org/data/2.5/weather?q=Sofia';

    this.getWeather = function () {
        var defer = $q.defer();
        $http.get(apiUrl)
        .success(function (data) {
            console.log(data);
            defer.resolve({
                icon: baseImageUrl + data.weather[0].icon + '.png',
                deg: data.main.temp - 272.15
            });
        });
        return defer.promise;
    };

    return this;
}
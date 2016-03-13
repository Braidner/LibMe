/**
 * Created by goodl on 3/9/2016.
 */

(function () {
    angular.module('ContentModule', ['ContentServices'])
        .config(RouteConfig)
        .controller('AllContentCtrl', AllContentCtrl)
        .controller('SerialContentCtrl', SerialContentCtrl)
        .controller('FilmContentCtrl', FilmContentCtrl);

    function RouteConfig($routeProvider) {
        "ngInject";
        $routeProvider.when('/', {
            templateUrl: '/app/content/content.html',
            controller: 'AllContentCtrl'
        }).when('/film', {
            templateUrl: '/app/content/content.html',
            controller: 'FilmContentCtrl'
        }).when('/serial', {
            templateUrl: '/app/content/content.html',
            controller: 'SerialContentCtrl'
        });
    }

    function AllContentCtrl($scope) {
        "ngInject";
        $scope.content = [
            // {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {type: 'film', id: 1, name: 'Batman v Superman: Dawn of Justice', poster: 'http://www.kinopoisk.ru/images/film_big/770631.jpg'},
            {type: 'serial', id: 1, name: 'The flash', poster: 'http://www.kinopoisk.ru/images/film_big/817506.jpg'},
            {type: 'film', id: 1, name: 'The Justice League Part One', poster: 'http://www.kinopoisk.ru/images/film_big/424994.jpg'},
            {type: 'film', id: 1, name: 'Untitled Spider-Man Reboot', poster: 'http://www.kinopoisk.ru/images/film_big/690593.jpg'},
            // {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            // {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            // {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            // {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            // {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            // {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'}
        ];
    }

    function FilmContentCtrl($scope) {
        "ngInject";
        $scope.content = [
            {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {type: 'film', id: 1, name: 'Batman v Superman: Dawn of Justice', poster: 'http://www.kinopoisk.ru/images/film_big/770631.jpg'},
            {type: 'serial', id: 1, name: 'The flash', poster: 'http://www.kinopoisk.ru/images/film_big/817506.jpg'},
            {type: 'film', id: 1, name: 'The Justice League Part One', poster: 'http://www.kinopoisk.ru/images/film_big/424994.jpg'},
            {type: 'film', id: 1, name: 'Untitled Spider-Man Reboot', poster: 'http://www.kinopoisk.ru/images/film_big/690593.jpg'},
            {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'}
        ];
    }

    function SerialContentCtrl($scope) {
        "ngInject";
        $scope.content = [
            // {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            // {type: 'film', id: 1, name: 'Batman v Superman: Dawn of Justice', poster: 'http://www.kinopoisk.ru/images/film_big/770631.jpg'},
            // {type: 'serial', id: 1, name: 'The flash', poster: 'http://www.kinopoisk.ru/images/film_big/817506.jpg'},
            // {type: 'film', id: 1, name: 'The Justice League Part One', poster: 'http://www.kinopoisk.ru/images/film_big/424994.jpg'},
            // {type: 'film', id: 1, name: 'Untitled Spider-Man Reboot', poster: 'http://www.kinopoisk.ru/images/film_big/690593.jpg'},
            // {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            // {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            // {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {type: 'film', id: 1, name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'}
        ];
    }
})();
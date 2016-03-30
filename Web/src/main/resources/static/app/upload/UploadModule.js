/**
 * Created by Braidner on 06/03/2016.
 */
(function () {
    'use strict';

    angular.module('UploadModule', ['ngResource']);
    angular.module('UploadModule').config(RouteConfig);
    angular.module('UploadModule').controller('UploadCtrl', UploadCtrl);

    function RouteConfig($routeProvider) {
        "ngInject";
        $routeProvider.when('/upload', {
            templateUrl: '/app/upload/upload.html',
            controller: 'UploadCtrl'
        });
    }
    

    UploadCtrl.$inject = ['$scope', 'ContentService'];
    function UploadCtrl($scope, ContentService) {
        "ngInject";
        $scope.content = [
            {type: 'film',  name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {type: 'serial',  name: 'Batman v Superman: Dawn of Justice', poster: 'http://www.kinopoisk.ru/images/film_big/770631.jpg'},
            {type: 'serial', name: 'The flash', poster: 'http://www.kinopoisk.ru/images/film_big/817506.jpg'},
            {type: 'film',  name: 'The Justice League Part One', poster: 'http://www.kinopoisk.ru/images/film_big/424994.jpg'},
            {type: 'film',  name: 'Untitled Spider-Man Reboot', poster: 'http://www.kinopoisk.ru/images/film_big/690593.jpg'},
            {type: 'serial',  name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'}
        ];

        // angular.forEach($scope.content, function (content) {
        //     ContentService.createContent(content);
        // });
    }

})();
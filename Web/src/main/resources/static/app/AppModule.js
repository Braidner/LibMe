/**
 * Created by Braidner on 30/01/2016.
 */
(function () {
    'use strict';

    angular.module('App', [
        'ngRoute',

        //Modules
        'LibraryModule'
    ]).controller("LastContentCtrl", LastContentCtrl);


    angular.module('App').run(function ($rootScope) {
        $rootScope.$on('$routeChangeStart', function (event, next) {
            console.log(next);
        });
    });

    angular.module('App').config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
        $routeProvider.when('/', {
            templateUrl: '/app/library/library.html',
            controller: 'LibraryCtrl'
        }).when('/film', {
            templateUrl: '/app/library/library.html',
            controller: 'FilmCtrl'
        }).when('/serial', {
            templateUrl: '/app/library/library.html',
            controller: 'FilmCtrl'
        }).otherwise({
            redirectTo: '/'
        });
        $locationProvider.html5Mode(true);
    }]);

    angular.module('App').controller('AppCtrl', function ($scope) {
        $scope.activeTab = "";

        $scope.$on('$routeChangeSuccess', function (event, current) {
            $scope.activeTab = current.$$route.originalPath;
        });

        $scope.tabs = [
            new Tab("/", "Все", true),
            new Tab("/film", "Фильмы"),
            new Tab("/serial", "Сериалы"),
            new Tab("/anime", "Аниме"),
            new Tab("/other", "Прочее")
        ];
    });

    LastContentCtrl.$inject = ['$scope'];
    function LastContentCtrl($scope) {
        $scope.library = [
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Batman v Superman: Dawn of Justice', poster: 'http://www.kinopoisk.ru/images/film_big/770631.jpg'},
            {name: 'The flash', poster: 'http://www.kinopoisk.ru/images/film_big/817506.jpg'},
            {name: 'The Justice League Part One', poster: 'http://www.kinopoisk.ru/images/film_big/424994.jpg'},
            {name: 'Batman v Superman: Dawn of Justice', poster: 'http://www.kinopoisk.ru/images/film_big/770631.jpg'},
            {name: 'Untitled Spider-Man Reboot', poster: 'http://www.kinopoisk.ru/images/film_big/690593.jpg'}
        ]
    }

    function Tab(id, name, selected) {
        this.id = id;
        this.name = name;
        this.selected = selected;
    }

    Tab.prototype = {
        id: "",
        name: "",
        selected: false
    };

    angular.module('App').directive('background', function(){
        return function(scope, element, attrs){
            var url = attrs.background;
            element.css({
                'background-image': 'url(' + url +')',
                'background-size' : 'cover'
            });
        };
    });



})();
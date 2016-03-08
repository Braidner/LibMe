/**
 * Created by Braidner on 30/01/2016.
 */
(function () {
    'use strict';

    angular.module('App', [
        'ngRoute',

        //Modules
        'LibraryModule',
        'RecentModule'
    ])
        .controller("NavigationCtrl", NavigationCtrl);


    angular.module('App').run(function ($rootScope) {
        $rootScope.$on('$routeChangeStart', function (event, next) {
             //TODO add monitoring
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

    function NavigationCtrl ($scope) {
        $scope.activeTab = "/";

        $scope.$on('$routeChangeSuccess', function (event, current) {
            if (current.$$route) {
                $scope.activeTab = current.$$route.originalPath;
            }
            var totalWidth = $('menu ul').width();
            $("menu ul li").each(function (index, el) {
                var width = $(el).outerWidth();
                var tab = $scope.tabs[index];
                tab.index = index;
                if (index == 0) {
                    tab.left = 0;
                    tab.right = totalWidth - width;
                } else {
                    var lastTab = $scope.tabs[index - 1];
                    tab.left = totalWidth - lastTab.right;
                    tab.right = lastTab.right - width;
                }
                if (tab.id === $scope.activeTab) {
                    selectTab(tab);
                }
            });
        });

        $scope.tabs = [
            new Tab("/", "Все"),
            new Tab("/film", "Фильмы"),
            new Tab("/serial", "Сериалы"),
            new Tab("/anime", "Аниме"),
            new Tab("/other", "Прочее")
        ];
        
        $scope.selectTab = selectTab;

        function selectTab(tab) {
            var selectedTab;
            var indicator = $('.menu-indicator');
            var index = $('.active-menu').index();

            selectedTab = $scope.tabs[tab.index];
            if (index > tab) {
                indicator.addClass("left");
                indicator.css({left: selectedTab.left});
                indicator.css({right: selectedTab.right});
            } else {
                indicator.addClass("right");
                indicator.css({right: selectedTab.right});
                indicator.css({left: selectedTab.left});
            }
        }
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
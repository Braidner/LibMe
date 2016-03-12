/**
 * Created by Braidner on 30/01/2016.
 */
(function () {
    'use strict';

    angular.module('App', [
        'ngRoute',
        'ngAnimate',

        //Modules
        'ContentModule',
        'ItemModule',
        'RecentModule'
    ])
        .config(RouteConfig)
        .run(MonitorConfig)
        .controller("NavigationCtrl", NavigationCtrl);

    function MonitorConfig($rootScope) {
        "ngInject";
        $rootScope.activeTab = "/";
        $rootScope.$on('$routeChangeStart', function (event, next) {
            //TODO add monitoring
            if (next.$$route) {
                $rootScope.activeTab = next.$$route.originalPath;
            }
        });
    }
    
    function RouteConfig($routeProvider, $locationProvider) {
        "ngInject";
        $routeProvider.otherwise({
            redirectTo: '/'
        });
        $locationProvider.html5Mode(true);
    }

    function NavigationCtrl ($scope) {
        "ngInject";

        $scope.$on('$routeChangeStart', function (event, current) {
            var totalWidth = $('menu ul').width();
            $("menu ul li").each(function (index, el) {
                var width = $(el).outerWidth();
                var tab = $scope.tabs[index];
                tab.index = index;
                if (index === 0) {
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
            if (index > tab.index) {
                indicator.removeClass("right");
                indicator.addClass("left");
                indicator.css({left: selectedTab.left});
                indicator.css({right: selectedTab.right});
            } else {
                indicator.removeClass("left");
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
/**
 * Created by goodl on 3/9/2016.
 */
(function () {
    angular.module('ItemModule', [])
        .directive('contentItem', contentItem);

    contentItem.$inject = ['$location'];
    function contentItem($location) {
        "ngInject";
        function linker(scope, element, attr) {
            element.on('click', function (event) {
                console.log(scope.item);
                $location.path("/film/" + scope.item.name);
                scope.$apply();
            });
        }
        return {
            link: linker,
            restrict: 'E',
            replace: true,
            scope: {
                item: '='
            },
            templateUrl: '/app/item/item.html'
        };
    }
})();
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
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Batman v Superman: Dawn of Justice', poster: 'http://www.kinopoisk.ru/images/film_big/770631.jpg'},
            {name: 'The flash', poster: 'http://www.kinopoisk.ru/images/film_big/817506.jpg'},
            {name: 'The Justice League Part One', poster: 'http://www.kinopoisk.ru/images/film_big/424994.jpg'},
            {name: 'Untitled Spider-Man Reboot', poster: 'http://www.kinopoisk.ru/images/film_big/690593.jpg'},
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'}
        ];
    }

    function FilmContentCtrl($scope) {
        "ngInject";
        $scope.content = [
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Batman v Superman: Dawn of Justice', poster: 'http://www.kinopoisk.ru/images/film_big/770631.jpg'},
            {name: 'The flash', poster: 'http://www.kinopoisk.ru/images/film_big/817506.jpg'},
            {name: 'The Justice League Part One', poster: 'http://www.kinopoisk.ru/images/film_big/424994.jpg'},
            {name: 'Untitled Spider-Man Reboot', poster: 'http://www.kinopoisk.ru/images/film_big/690593.jpg'},
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'}
        ];
    }

    function SerialContentCtrl($scope) {
        "ngInject";
        $scope.content = [
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Batman v Superman: Dawn of Justice', poster: 'http://www.kinopoisk.ru/images/film_big/770631.jpg'},
            {name: 'The flash', poster: 'http://www.kinopoisk.ru/images/film_big/817506.jpg'},
            {name: 'The Justice League Part One', poster: 'http://www.kinopoisk.ru/images/film_big/424994.jpg'},
            {name: 'Untitled Spider-Man Reboot', poster: 'http://www.kinopoisk.ru/images/film_big/690593.jpg'},
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'}
        ];
    }
})();
/**
 * Created by goodl on 3/9/2016.
 */
(function () {
    angular.module('ContentServices', []).service('ContentService', ContentService);

    function ContentService() {

    }
})();

/**
    * Created by Braidner
    */
(function () {
    'use strict';

    angular.module('RecentModule', [])
        .controller("RecentCtrl", RecentCtrl);

    RecentCtrl.$inject = ['$scope'];
    function RecentCtrl($scope) {
        "ngInject";
        $scope.content = [
            {name: 'Frozen', poster: 'http://www.kinopoisk.ru/images/film_big/493208.jpg'},
            {name: 'Batman v Superman: Dawn of Justice', poster: 'http://www.kinopoisk.ru/images/film_big/770631.jpg'},
            {name: 'The flash', poster: 'http://www.kinopoisk.ru/images/film_big/817506.jpg'},
            {name: 'The Justice League Part One', poster: 'http://www.kinopoisk.ru/images/film_big/424994.jpg'},
            {name: 'Batman v Superman: Dawn of Justice', poster: 'http://www.kinopoisk.ru/images/film_big/770631.jpg'},
            {name: 'Untitled Spider-Man Reboot', poster: 'http://www.kinopoisk.ru/images/film_big/690593.jpg'}
        ];
    }

    angular.module('RecentModule').directive('owlCarousel', function() {

        var linker = function (scope, element, attr) {
            
            var loadCarousel = function () {
                element.owlCarousel({items: 6, itemsDesktop: [1300, 5]});
            };

            scope.$watchCollection(attr.owlCarousel, function () {
                loadCarousel();
            });

        };

        return {
            restrict: "A",
            link: linker
        };

    });
})();
/**
 * Created by Braidner on 06/03/2016.
 */
(function () {
    'use strict';
})();
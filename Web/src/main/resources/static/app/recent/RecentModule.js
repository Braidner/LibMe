/**
 * Created by Braidner on 30/01/2016.
 */
(function () {
    'use strict';

    angular.module('RecentModule', [])
        .controller("RecentCtrl", RecentCtrl);

    RecentCtrl.$inject = ['$scope'];
    function RecentCtrl($scope) {
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

            scope.$watchCollection(attr.owlCarousel, function (value) {
                loadCarousel();
            });

        };

        return {
            restrict: "A",
            link: linker
        }

    });
})();
/**
 * Created by goodl on 3/9/2016.
 */

(function () {
    angular.module('ContentModule', ['ContentServices'])
        .controller('AllContentCtrl', AllContentCtrl)
        .controller('SerialContentCtrl', SerialContentCtrl)
        .controller('FilmContentCtrl', FilmContentCtrl);
    
    function AllContentCtrl($scope) {
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
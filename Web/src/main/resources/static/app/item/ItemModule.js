/**
 * Created by goodl on 3/9/2016.
 */
(function () {
    angular.module('ItemModule', [])
        .directive('contentItem', contentItem);

    function contentItem() {
        return {
            restrict: 'E'
        }
    }
})();
/**
 * Created by KuznetsovNE on 04.04.2016.
 */
(function () {
    angular.module('control.parser', []);

    angular.module('ControlsModule').directive('lmUrlParser', lmUrlParser);

    function lmUrlParser() {
        return {
            scope: {
                bindModel:'=ngModel'
            },
            require: 'ngModel',
            transclude: true,
            'templateUrl': '/app/control/input/input-control.html',
            link: function (scope, elem, attr, ngModel) {
                "use strict";
                // elem.on('click', function () {
                //     elem.addClass('lm-input-focused');
                // });
            }
        };
    }

})();
// This is app.js
//
angular.module("testCometApp", ['ui.router', 'app.controllers'])

.config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/home");

    $stateProvider.state('home', {
        url: "/home",
        templateUrl: '/templates/home'
    }).
    state('about', {
        url: "/about",
        templateUrl: '/templates/about'
    });
});

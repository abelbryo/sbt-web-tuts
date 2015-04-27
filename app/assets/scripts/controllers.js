angular.module("app.controllers", [])

.controller("MainCtrl", function($scope){

    // This is what is called by the commet
    // from the server side.
    window.cometMessage = function(message){

        $scope.$apply(function(){
            $scope.cometString = message;
        });

    };
})

.controller("HomeCtrl", function($scope, $http){

    $scope.submitForm = function(){
        $http.post('/message', $scope.user).success(function(data){
            console.log(data);
            $scope.user = {};
            $scope.chatForm.$setPristine();
        });
    };

});

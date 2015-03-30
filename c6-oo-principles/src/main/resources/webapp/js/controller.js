angular.module('diskApp', []).controller("DisksListCtrl", function ($scope, $http, filterFilter) {
    $scope.disks = [];
    $scope.cart = {totalItem:0};

    $scope.isList = true;
    $scope.isCart = false;
    $scope.totalPrice = 0.0;
    $scope.disk = {};


    $scope.init = function () {
        getDisks();
        $scope.goToCart(true);
    }


    $scope.goToCart = function (isInit) {
        $scope.isList = isInit;
        $scope.isCart = !isInit;

        $http({
            method: 'GET',
            url: '/cart'
        }).success(function (data) {
            console.log(data);
            $scope.cart = data;
        }).error(function (error) {
        });
    };

    $scope.goToList = function () {
        $scope.isList = true;
        $scope.isCart = false;
    };


    $scope.addDisk = function () {
        $http({
            method: 'POST',
            url: '/disks/add',
            data: JSON.stringify($scope.disk),
            contentType: "application/json"
        }).success(function () {
                getDisks();
            }
        );
    };

    $scope.removeDisk = function (disk) {
        $http({
            method: 'DELETE',
            url: '/disks/remove/' + getIndexOfDisk(disk)
        }).success(function () {
            getDisks();
        });

    };

    $scope.addToCart = function (disk) {
        console.log(disk);
        $http({
            method: 'POST',
            url: '/cart/add',
            data: JSON.stringify(_.omit(disk, "$$hashKey")),
            contentType: "application/json"
        }).success(function (cart) {
            console.log(cart);
            $scope.cart = cart;
        });
    };

    $scope.isAllChecked = function () {
        var checkBoxes = $(".check-self");
        var flag = 0;
        angular.forEach(checkBoxes, function (checkbox) {
            if (checkbox.checked) {
                flag++;
            }
        });

        if (flag == checkBoxes.length) {
            $('.check-all')[0].checked = true;
        }
        else {
            $('.check-all')[0].checked = false;
        }

        $scope.caculateTotalPrice();
    };

    $scope.caculateTotalPrice = function () {
        var checkBoxes = $(".check-self");

        $scope.totalPrice = 0.0;
        for (var i = 0; i < checkBoxes.length; i++) {
            if (checkBoxes[i].checked) {
                $scope.totalPrice += $scope.cart[i].number * $scope.cart[i].price;
            }
        }
    };

    function getIndexOfDisk(disk) {
        return $scope.disks.indexOf(disk);
    };

    function getDisks() {
        $http({
            method: 'GET',
            url: '/disks',
            contentType: "application/json;charset=utf-8"
        }).success(function (data) {
            console.log(data);
            $scope.disks = data;
        }).error(function (error) {
            console.log(error);
        });
    };

});

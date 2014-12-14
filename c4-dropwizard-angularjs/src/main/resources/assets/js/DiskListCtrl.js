function DiskListCtrl($scope) {
    $scope.init = function () {
        listDisks();
    };

    function listDisks() {
        $.ajax({
            url: "/disks/list",
            type: "GET"
        }).done(function (disks) {
            $scope.disks = disks;
        });
    }

    $scope.add = function () {
        $.ajax({
            url: "/disks/add",
            type: "POST",
            data: JSON.stringify($scope.disk),
            contentType: "application/json",
            success: function (disk) {
                listDisks();
            }
        })
    }

}
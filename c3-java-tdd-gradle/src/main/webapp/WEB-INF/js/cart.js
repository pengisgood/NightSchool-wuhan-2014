var selectedItems = [];

function addToCartButton(name) {
    return $("<button>")
        .html("add to cart")
        .click(function () {
            addToCart(name);
        });
}

function addToCart(name) {
    var item = _.find(disks, function (disk) {
        return disk.name === name;
    });

    selectedItems.push(item);
}

function goToCart() {

}

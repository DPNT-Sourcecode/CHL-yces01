package befaster.solutions.CHL;

class Product {
    private Integer price;
    private Integer multiBuyQuantity;
    private Integer multiBuyPrice;

    public Product(int price) {
        this.price = price;
        this.multiBuyQuantity = null;
        this.multiBuyPrice = null;
    }

    public Product(int price, int multiBuyQuantity, int multiBuyPrice) {
        this.price = price;
        this.multiBuyQuantity = multiBuyQuantity;
        this.multiBuyPrice = multiBuyPrice;
    }

    public Integer calculatePriceFor(Integer quantity) {
        if (multiBuyAvailable()) {
            return calculateMultiBuyPrice(quantity);
        }

        return price * quantity;

    }

    private boolean multiBuyAvailable() {
        return multiBuyQuantity != null;
    }

    private Integer calculateMultiBuyPrice(Integer quantity) {
        int multiBuys = quantity / multiBuyQuantity;
        int remainderNonMultiBuys = quantity % multiBuyQuantity;

        return (multiBuys * multiBuyPrice) + (remainderNonMultiBuys * price);
    }
}
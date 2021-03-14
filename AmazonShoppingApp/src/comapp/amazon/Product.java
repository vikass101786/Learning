package comapp.amazon;

public class Product {

    public Integer productId;
    public String productName;
    public Integer price;
    private Size size;
    private Color color;
    public ProductType productType;
    public Seller sellerDetails;

    public Product(Integer productId, String productName, Integer price, ProductType productType, Seller sellerDetails) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.productType = productType;
        this.sellerDetails = sellerDetails;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getPrice() {
        return price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public Seller getSellerDetails() {
        return sellerDetails;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", productType=" + productType +
                ", sellerDetails=" + sellerDetails +
                '}';
    }
}

package comapp.amazon;

public class Seller {
    public String sellerName;
    public Integer sellerId;
    public Address sellerAddress;
    Catalogue catalogue;

    public Seller(String sellerName, Integer sellerId, Address sellerAddress) {
        this.sellerName = sellerName;
        this.sellerId = sellerId;
        this.sellerAddress = sellerAddress;
        this.catalogue = new Catalogue();
    }

    public String getSellerName() {
        return this.sellerName;
    }

    public Integer getSellerId() {
        return this.sellerId;
    }

    public Address getSellerAddress() {
        return this.sellerAddress;
    }

    public Integer addProduct(Product product) {
        this.catalogue.addProductInCatalogue(product);
        return product.getProductId();
    }

    public Integer editProduct(Integer productId, Product product) {
        this.catalogue.removeProduct(productId, this.getSellerId());
        return this.addProduct(product);
    }

    public void removeProduct(Integer productId) {
        this.catalogue.removeProduct(productId, this.getSellerId());
    }

    public String toString() {
        return "Seller{sellerName='" + this.sellerName + '\'' + ", sellerId=" + this.sellerId + ", sellerAddress=" + this.sellerAddress + '}';
    }
}

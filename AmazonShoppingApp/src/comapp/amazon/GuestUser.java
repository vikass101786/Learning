package comapp.amazon;

import java.util.List;

public class GuestUser implements Customer {
    public String customerName;
    public Integer customerId;
    Search searchService;
    Cart cart;

    public GuestUser(String customerName, Integer customerId) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.searchService = new Search();
        cart = new Cart();
    }

    public List<Product> searchProductByName(String productName) {
        return searchService.searchProductByName(productName);
    }

    public List<Product> searchProductByCategory(ProductType productType) {
        return searchService.searchProductByCategory(productType);
    }

    public List<Product> viewAllProduct() {
        return searchService.viewAllProduct();
    }

    @Override
    public Integer addItemInCart(Product product) {
        return null;
    }

    @Override
    public void removeItemFromCart(Integer productId) {

    }

    @Override
    public Product editItemInCart(Product product) {
        return null;
    }
}

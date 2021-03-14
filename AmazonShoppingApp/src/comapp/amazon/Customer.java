package comapp.amazon;

import java.util.List;

public interface Customer {

    public Integer addItemInCart(Product product);
    public void removeItemFromCart(Integer productId);
    public Product editItemInCart(Product product);
    public List<Product> searchProductByName(String productName);
    public List<Product> searchProductByCategory(ProductType productType);
    public List<Product> viewAllProduct();

}

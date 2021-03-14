package comapp.amazon;

import java.util.List;

public class Search {

    private final Catalogue catalogue;

    Search() {

        catalogue = new Catalogue();
    }

     List<Product> searchProductByName(String productName) {
        return catalogue.searchProductByName(productName);
    }

     List<Product> searchProductByCategory(ProductType productType) {
        return catalogue.searchProductByProductType(productType);
    }

     List<Product> viewAllProduct() {
        return  catalogue.getAllProduct();
    }
}

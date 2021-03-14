package comapp.amazon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public final class Catalogue {
    private static final Map<ProductType, List<Product>> productMap = new HashMap();

    public Catalogue() {
    }

    public void addProductInCatalogue(Product product) {
        productMap.putIfAbsent(product.getProductType(), new ArrayList());
        ((List)productMap.get(product.getProductType())).add(product);
        System.out.println(productMap);
    }

    public List<Product> searchProductByProductType(ProductType type) {
        return (List)productMap.get(type);
    }

    public List<Product> searchProductByName(String productName) {
        return (List)productMap.values().stream().flatMap(Collection::stream).filter((product) -> {
            return product.getProductName().equals(productName);
        }).collect(Collectors.toList());
    }

    public Optional<Product> getProductById(Integer productId) {
        return productMap.values().stream().flatMap(Collection::stream).filter((product) -> {
            return product.getProductId().equals(productId);
        }).findFirst();
    }

    public List<Product> getAllProduct() {
        return (List)productMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }

    /*public void removeProduct(Integer productId, Integer sellerId) {
        Iterator iterator = productMap.entrySet().iterator();

        while(iterator.hasNext()) {
            ((List)((Entry)iterator.next()).getValue()).removeIf((product) -> {
                product.
                return product.getProductId().equals(productId) && product.getSellerDetails().getSellerId().equals(sellerId);
            });
        }
    }*/
}

package comapp.amazon;

import java.io.PrintStream;
import java.util.List;

public class AmazonShoppingHandler {
    public AmazonShoppingHandler() {
    }

    public static void main(String[] args) {
        String sellerName = "mobile phone seller";
        Integer sellerId = 10;
        Address address1 = new Address("Street 10", "Kanpur", 10);
        Seller seller1 = new Seller(sellerName, sellerId, address1);
        Product product = new Product(1, "iphone 12", 100, ProductType.MOBILE, seller1);
        seller1.addProduct(product);
        String sellerName1 = "furniture seller";
        Integer sellerId1 = 20;
        Address address2 = new Address("Street 20", "Lucknow", 30);
        Seller seller2 = new Seller(sellerName1, sellerId1, address2);
        Product product1 = new Product(2, "sofa", 1000, ProductType.FURNITURE, seller2);
        seller2.addProduct(product1);
        String sellerName3 = "iphone seller";
        Integer sellerId3 = 30;
        Address address3 = new Address("Street 30", "Ahemdabad", 90);
        Seller seller3 = new Seller(sellerName3, sellerId3, address3);
        Product product3 = new Product(1, "iphone 12 mini", 100, ProductType.MOBILE, seller3);
        seller1.addProduct(product3);
        Customer customer1 = new GuestUser("Ram", 10);
        Customer customer2 = new GuestUser("Vikas", 20);
        System.out.println("========== CUSTOMER 1 SEARCH ==================");
        List var10000 = customer1.searchProductByName("iphone 12");
        PrintStream var10001 = System.out;
        var10000.forEach(var10001::println);
        System.out.println("========== CUSTOMER 2 SEARCH ==================");
        var10000 = customer2.viewAllProduct();
        var10001 = System.out;
        var10000.forEach(var10001::println);
        seller1.removeProduct(2);
    }
}

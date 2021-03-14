public class BirdController {

    public static void main(String[] args) {
        Bird hen = new Hen("yellow",2);
        Sellable henToSell = new Hen("yellow",2);
        System.out.println(hen.swim());
        Seller seller = new Seller();
        System.out.println(seller.sell(henToSell));

        Sellable migSeller = new Mig21(3000);
        System.out.println(seller.sell(migSeller));

        Sellable kiwiSeller = new Kiwi("Black and White",2, Size.LARGE);
        System.out.println(seller.sell(kiwiSeller));
    }

}

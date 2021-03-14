import java.io.Serializable;

public class Hen extends Bird implements Sellable,Flyable  {

    public Hen(String color, Integer legs) {
        super(color, legs);
    }

    public String fly() {
        return "Hen can fly, but not that high";
    }

    public String swim() {
        return "Never seen hen swimming";
    }

    public String hatch() {
        return "golden egg";
    }

    @Override
    public String getSellingPrice() {
        return 1000+ " Rs";
    }
}

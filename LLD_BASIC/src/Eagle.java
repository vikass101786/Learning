public class Eagle extends Bird implements Flyable {

    public Eagle(String color, Integer legs) {
        super(color, legs);
    }

    public String fly() {
        return "Eagle can fly high";
    }

    public String swim() {
        return "Eagle may swim !!";
    }

    public String hatch() {
        return "Eagle - not a golden egg";
    }

}

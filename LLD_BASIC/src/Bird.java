public abstract class Bird {


    private String color;
    private Integer legs;


    public Bird(String color, Integer legs) {
        this.color = color;
        this.legs = legs;
    }

    public String getColor() {
        return color;
    }

    public Integer getLegs() {
        return legs;
    }

    public String swim() {
        return "default swim";
    }

    public abstract String hatch();



}

public class Kiwi extends Bird implements Sellable{

    Size size;

    public Kiwi(String color, Integer legs, Size size) {
        super(color, legs);
        this.size=size;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public String hatch() {
        return "Kiwi can hatch";
    }

    @Override
    public String getSellingPrice() {
        if (this.getSize() == Size.LARGE)
            return "30 RS";
        else if (this.getSize() == Size.MEDIUM)
            return "20 RS";
        else
            return "10 RS";
    }
}

enum Size {
    MEDIUM,SMALL,LARGE;
}
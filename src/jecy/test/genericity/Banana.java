package jecy.test.genericity;

public class Banana extends Fruit{
    public Banana(String name, String color) {
        super(name, color);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("This is banana. ").append("name=").append(this.name).append(", color=")
                .append(this.color).toString();
    }
}

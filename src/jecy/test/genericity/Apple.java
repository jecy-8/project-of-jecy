package jecy.test.genericity;

public class Apple extends Fruit {
    public Apple(String name, String color) {
        super(name, color);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("This is apple. ").append("name=").append(this.name).append(", color=")
                .append(this.color).toString();
    }
}

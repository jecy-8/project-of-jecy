package jecy.test.genericity;

public class Fruit extends Food{

    public Fruit(String name, String color) {
        super(name, color);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("This is fruit. ").append("name=").append(this.name).append(", color=")
                .append(this.color).toString();
    }
}

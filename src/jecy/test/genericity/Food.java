package jecy.test.genericity;

public class Food {
    String name;
    String color;

    public Food(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append("This is food. ").append("name=").append(this.name).append(", color=")
                .append(this.color).toString();
    }
}

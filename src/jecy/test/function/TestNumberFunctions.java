package jecy.test.function;

public class TestNumberFunctions {
    public static void main(String[] args) {
        NumberFunctions.of(10).add(20).sub(2).filter(e -> e >20).get().operate(System.out::println);
    }
}

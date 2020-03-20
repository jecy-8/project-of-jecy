package jecy.test.function;

@FunctionalInterface
public interface OperateNumberFunctions {

    void operate(Integer number);

    default void print() {

    }
}

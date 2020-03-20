package jecy.test.function;

import java.util.Optional;
import java.util.function.Predicate;

public class NumberFunctions {
    private Integer number;

    private NumberFunctions() {}

    private static NumberFunctions numberFunctions = new NumberFunctions();

    public static NumberFunctions of(Integer number) {
        numberFunctions.number = number;
        return numberFunctions;
    }

    public static NumberFunctions add(Integer number) {
        numberFunctions.number += number;
        return numberFunctions;
    }

    public static NumberFunctions sub(Integer number) {
        numberFunctions.number -= number;
        return numberFunctions;
    }

    public Optional<NumberFunctions> filter(Predicate<Integer> predicate) {
        if (predicate.test(this.number))
            return Optional.of(numberFunctions);
        return Optional.ofNullable(new NumberFunctions());
    }

    public void operate(OperateNumberFunctions functions) {
        functions.operate(this.number);
    }
}

import java.util.*;

public class CachedCalculator implements Calculator{

    private final Calculator calculator;
    private final Map<Integer, Integer> resultByArg = new HashMap<>();

    public CachedCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int calc(int arg) {
        if(!resultByArg.containsKey(arg)){
            int result = calculator.calc(arg);
            resultByArg.put(arg, result);
        }

        System.out.println("The value is get from cache");

        return resultByArg.get(arg);
    }
}

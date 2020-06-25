import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        // run(new CachedCalculator(new CalculatorImpl()));
        Calculator calculator = new CalculatorImpl();

        Class<?> proxyClass = Proxy.getProxyClass(Calculator.class.getClassLoader(), Calculator.class);

        try {
            Calculator calculatorProxy = (Calculator)proxyClass.getConstructor(InvocationHandler.class)
                    .newInstance(new CacheHandler(calculator));

            int result;
            result = calculatorProxy.calc(1);
            result = calculatorProxy.calc(2);
            result = calculatorProxy.calc(1);
        }catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e){
            e.printStackTrace();
        }
    }
}

import com.sun.deploy.net.proxy.ProxyUtils;

public class Main {
    public static void main(String[] args) {
        // run(new CachedCalculator(new CalculatorImpl()));
        Calculator calculator = new CalculatorImpl();
        calculator.calc(1);
        calculator.calc(1);

        Calculator cached = new CachedCalculator(calculator);
        cached.calc(1);
        cached.calc(2);
        cached.calc(1);
    }

    private static void run(Calculator calculator) {
        System.out.println(1);
        System.out.println(5);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
        System.out.println(1);
    }
}

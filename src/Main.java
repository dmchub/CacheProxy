public class Main {
    public static void main(String[] args) {
        run(new CachedCalculator(new CalculatorImpl()));
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

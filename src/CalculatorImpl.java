public class CalculatorImpl implements Calculator {

    @Override
    public int calc(int arg) {
        System.out.println("calc" + arg);

        return arg * 5;
    }
}

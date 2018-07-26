package alg.calculate;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareRootTest {

    final SquareRoot calculator = new SquareRoot();

    @Test
    public void calculate() {
        System.out.println(calculator.calculate(0));
        System.out.println(calculator.calculate(1));
        System.out.println(calculator.calculate(2));
        System.out.println(calculator.calculate(4));
        System.out.println(calculator.calculate(5));
        System.out.println(calculator.calculate(8));
        System.out.println(calculator.calculate(9));
        System.out.println(calculator.calculate(2147395599));
    }
}
package javalang.datastruct;

import org.junit.Test;

import java.lang.reflect.Method;

public class JavaGenerics {

    class Printer {
        public void printArray(Object[] items) {
            for (Object item : items) {
                System.out.println(item);
            }
        }
    }

    @Test
    public final void test() {
        Printer myPrinter = new Printer();
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();

            if(name.equals("printArray"))
                count++;
        }

        if(count > 1)System.out.println("Method overloading is not allowed!");
    }
}

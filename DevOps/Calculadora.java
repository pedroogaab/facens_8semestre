public class Calculadora {
    public static void main(String[] args) {
        System.out.println("sum 3+5 = " + sum(3, 5));
        System.out.println("subtraction 6-15 = " + subtraction(6, 15));
        System.out.println("multiplication 5*5 = " + multiplication(5, 5));
        System.out.println("dvisom 54/12 = " + division(54, 12));

    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int subtraction(int a, int b) {
        return a - b;
    }

    public static int multiplication(int a, int b) {
        return a * b;

    }

    public static float division(float a, float b) {
        return a / b;

    }

}
import java.util.Scanner;

public class FibonacciLastDigitEfficient {

    private static int getFibonacciLastDigitEfficient(int n) {
        if (n <= 1) {
            return n;
        }

        int previous = 0;
        int current = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous % 10;
            previous = current % 10;
            current = tmp_previous + current;
        }

        return current % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitEfficient(n);
        System.out.println(c);
    }
}


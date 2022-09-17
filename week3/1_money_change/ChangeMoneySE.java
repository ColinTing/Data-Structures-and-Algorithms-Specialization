import java.util.Scanner;

public class ChangeMoneySE {
    private static int getChange(int m) {
        return m /10 + (m % 10) / 5 + m % 5;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}


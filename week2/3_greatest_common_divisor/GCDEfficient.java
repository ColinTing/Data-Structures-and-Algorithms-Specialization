import java.util.Scanner;

public class GCDEfficient {
  private static int gcd_efficient(int a, int b) {
    if (b == 0) {
      return a;
    }
    int d = a % b;
    return gcd_efficient(b, d);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_efficient(a, b));
  }
}

import java.util.Scanner;

public class LCMEfficient {

  private static int gcd_efficient(int a, int b) {
    if (b == 0) {
      return a;
    }
    int d = a % b;
    return gcd_efficient(b, d);
  }

  private static long lcm_efficient(int a, int b) {
    return ((long) a *b) / gcd_efficient(a, b);
  }


  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_efficient(a, b));
  }
}

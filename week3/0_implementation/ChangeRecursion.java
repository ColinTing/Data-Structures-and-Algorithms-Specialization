import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 丁浩
 * @date 2022年09月10日 11:29
 */

public class ChangeRecursion {

    private static long change(int money, int[] denominations) {
        if (money == 0) {
            return 0;
        }
        Arrays.sort(denominations);

        int maxCoin = binarySearch(denominations, money);

        return 1 + change(money - maxCoin, denominations);
    }


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int money = in.nextInt();
        int[] denominations = {1,4,6};
        System.out.println(change(money, denominations));
    }

    private static int binarySearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return a[mid]; // key found
            }
        }
        return low - 1 < 0 ? -1 : a[low - 1];
    }
}

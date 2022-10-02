import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 丁浩
 * @date 2022年09月10日 11:29
 */

public class Change {

    private static long change(int money, int[] denominations) {
        Arrays.sort(denominations);
        int numCoins = 0;
        while (money > 0) {
            int maxCoin = binarySearch(denominations, money);
            if (maxCoin >= 0) {
                money -= maxCoin;
                numCoins++;
            } else {
                return -1;
            }
        }
        return numCoins;
    }


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int money = in.nextInt();
        int[] denominations = {1,5,10};
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

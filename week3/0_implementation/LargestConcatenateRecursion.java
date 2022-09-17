import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author 丁浩
 * @date 2022年09月09日 09:23
 */

public class LargestConcatenateRecursion {

    private static String largestConcatenate(int[] numbers) {

        List<Integer> numbersList = Arrays.stream(numbers).boxed().collect(Collectors.toList());


        if (CollectionUtils.isEmpty(numbersList)) {
            return StringUtils.EMPTY;
        }


        Integer maxNumber = numbersList
            .stream()
            .mapToInt(v -> v)
            .max().orElseThrow(NoSuchElementException::new);

        numbersList.remove(maxNumber);

        return maxNumber + largestConcatenate(numbersList.stream().mapToInt(i->i).toArray());
    }


    public static void main(String args[]) {

        System.out.println("请输入几个数并用逗号隔开：");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] arr = str.split(",");
        int[] b = new int[arr.length];
        for (int j = 0; j < b.length; j++) {
            b[j] = Integer.parseInt(arr[j]);
        }
        System.out.println(largestConcatenate(b));
    }
}

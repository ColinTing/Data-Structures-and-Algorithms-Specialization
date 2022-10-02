import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, List<Item> items) {
        Collections.sort(items);
        double maxValue = 0;
        for (Item item : items) {
            if (capacity > 0) {
                int fraction = Math.min(capacity, item.getWeight());
                maxValue += fraction * item.getValuePerWeight();
                capacity -= fraction;
            }
        }

        return maxValue;
    }



    public static class Item implements Comparable<Item> {

        private final int value;
        private final int weight;
        private final double valuePerWeight;

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.valuePerWeight = (double) value / (double) weight;
        }

        public double getValuePerWeight() {
            return valuePerWeight;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Item o) {
            return Double.compare(o.getValuePerWeight(), valuePerWeight);
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
            items.add(new Item(values[i], weights[i]));
        }
        System.out.println(getOptimalValue(capacity, items));
    }
} 

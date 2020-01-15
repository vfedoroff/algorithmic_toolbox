import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {

    static class Item
    { 
        Double cost; 
        int w, v, i; 
          
        // item value function 
        public Item(final int w, final int v, final int i) {
            this.w = w;
            this.v = v;
            this.i = i;
            cost = Double.valueOf(v) / Double.valueOf(w);
        }
    }

    private static double getOptimalValue(int capacity, final int[] values, final int[] weights) {
        double value = 0d;
        final int len = values.length;
        // write your code here
        final Item[] items = new Item[len];
        for (int i = 0; i < len; i++) {
            items[i] = new Item(weights[i], values[i], i);
        }
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(final Item a, final Item b) 
            { 
                return a.cost.compareTo(b.cost); 
            }
        }.reversed());
        for (Item item : items) {
            // we can get a whole item
            if (capacity - item.w >= 0) {
                capacity = capacity - item.w;
                value += item.v; 
            } else {
                double fraction = ((double)capacity/(double)item.v); 
                value += item.v * fraction * item.cost;
                capacity = (int)(capacity - (item.w*fraction));
                break;
            }
        }
        return value;
    }

    public static void main(final String args[]) {
        final Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();
        final int capacity = scanner.nextInt();
        final int[] values = new int[n];
        final int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 

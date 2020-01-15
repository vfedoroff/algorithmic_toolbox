import java.util.Scanner;
import java.util.Arrays;

public class ChangeDP {
    private static int getChange(int m) {
        if (m == 0) {
            return 0;
        }
        int[] coins = new int[]{1,3,4};
        int[] table = new int[m+1];
        Arrays.fill(table, Integer.MAX_VALUE);
        table[0] = 0;
        for (int amt=1; amt <= m; amt++){
            // Now try taking every coin one at a time and pick the minimum
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= amt) { // check if coin value is less than amount
                    // select the coin and add 1 to solution of (amount-coin value)
                    table[amt] = Math.min(table[amt - coins[j]] + 1,table[amt]) ;
                }
            }
        }
        return table[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}


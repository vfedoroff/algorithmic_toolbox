import java.util.Arrays;
import java.util.Scanner;

public class Change {

    static final int coins[] =  {10, 5, 1}; 

    private static int getChange(int m) {
        if (m == 0) {
            return 0;
        }
        int table[] = new int[m + 1];
        Arrays.fill(table, Integer.MAX_VALUE);
        // Base case (If given value V is 0) 
        table[0] = 0;
        // Compute minimum coins required for all 
        // values from 1 to m
        for (int i = 1; i <= m; i++) 
        { 
            // Go through all coins smaller than i 
            for (int j = 0; j < 3; j++) 
            if (coins[j] <= i) 
            { 
                int sub_res = table[i - coins[j]]; 
                if (sub_res != Integer.MAX_VALUE  && sub_res + 1 < table[i])  {
                    table[i] = sub_res + 1; 
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


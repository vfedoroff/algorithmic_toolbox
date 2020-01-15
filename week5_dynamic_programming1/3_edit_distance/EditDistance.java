import java.util.*;

class EditDistance {

  public static int costOfSubstitution(char a, char b) {
    return a == b ? 0 : 1;
  }

  public static int min(int... numbers) {
    return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
  }

  public static int EditDistance(String s, String t) {
    int[][] dp = new int[s.length() + 1][t.length() + 1];

    for (int i = 0; i <= s.length(); i++) {
      for (int j = 0; j <= t.length(); j++) {
        if (i == 0) {
          dp[i][j] = j;
        } else if (j == 0) {
          dp[i][j] = i;
        } else {
          dp[i][j] = min(dp[i - 1][j - 1] + costOfSubstitution(s.charAt(i - 1), t.charAt(j - 1)), dp[i - 1][j] + 1,
              dp[i][j - 1] + 1);
        }
      }
    }

    return dp[s.length()][t.length()];
  }

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}

import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a) {
        int count = 0;
        int i = 0;
        int majorityElement = 0;
        int size = a.length;
        for (i = 0; i < size; i++) {
            if (count == 0)
                majorityElement = a[i];
            if (a[i] == majorityElement) 
                count++;
            else
                count--;
        }
        count = 0;
        for (i = 0; i < size; i++)
            if (a[i] == majorityElement)
                count++;
        if (count > size/2)
            return majorityElement;
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

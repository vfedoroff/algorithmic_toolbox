import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class BinarySearch {

    static int binarySearch(int[] a, int l, int r, int x) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (a[mid] == x) {
            return mid;
        }
        if (l == r) {
            return -1;
        }
        if (a[mid] > x) {
            return binarySearch(a, l, mid - 1, x);
        }
        return binarySearch(a, mid + 1, r, x);
    }

    static int binarySearch(int[] a, int x) {
        int l = 0, r = a.length - 1;
        return binarySearch(a, l, r, x);
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            // replace with the call to binarySearch when implemented
            System.out.print(binarySearch(a, b[i]) + " ");
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

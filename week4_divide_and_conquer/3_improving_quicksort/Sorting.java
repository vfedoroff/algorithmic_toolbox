import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static void swap(int[] a, int i, int j){
        int temp =  a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int  k = random.nextInt(r - l + 1) + l;
        swap(a, k, l);
        int lt = l; // We initiate lt to be the part that is less than the pivot
        int i = l;  // We scan the array from left to right
        int gt = r; // The part that is greater than the pivot
        int pivot = a[l];
        while(i <= gt){
            if (a[i] < pivot) {
                swap(a, lt, i);
                lt++;
                i++;
            } else if (a[i] > pivot) {
                swap(a, i, gt);
                gt--;
            } else {
                i++;
            }
        }
        randomizedQuickSort(a, l, lt-1);
        randomizedQuickSort(a, gt+1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
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


import java.util.*;
import java.io.*;

public class CarFueling {

    static int computeMinRefills(int dist, int tank, int[] stops) {
        int result = 0;
        int leftover = tank;
        int prev = 0;
        for (int i = 0; i < stops.length; i++) {
            int distance = stops[i] - prev;
            if (distance > tank)
                return -1;
            if (distance > leftover) {
                result++;
                leftover = tank;
            }
            leftover -= distance;
            prev = stops[i];
        }

        int lastDistance = dist - prev;
        if (lastDistance > tank)
            return -1;
        if (lastDistance > leftover)
            result++;

        return result;
    }

    public static void main(final String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int d = Integer.parseInt(bufferedReader.readLine());
            if (d < 1 || d > 100000) {
                new Exception("Invalid d value");
            }
            int m = Integer.parseInt(bufferedReader.readLine());
            if (m < 1 || m > 400) {
                new Exception("Invalid m value");
            }
            int n = Integer.parseInt(bufferedReader.readLine());
            if (n < 1 || n > 300) {
                new Exception("Invalid m value");
            }
            int[] stops = new int[n];
            String line = bufferedReader.readLine();
            String[] strings = line.trim().split(" ");
            if (strings.length != n){
                throw new Exception(String.format("Invalid string: %s", line));
            }
            for (int i = 0; i < n; i++) {
                stops[i] = Integer.parseInt(strings[i]);
            }
            System.out.println(computeMinRefills(d, m, stops));
        }
        catch (NumberFormatException nfe){
            System.out.println(-1);;
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }
}

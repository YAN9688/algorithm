import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int target = Integer.parseInt(input[1]);
        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }

        long x_min = 1;
        long x_max = Arrays.stream(arr).max().getAsInt();
        long find_x = 0;

        while (x_min <= x_max) {
            long num = 0;
            long x = (x_min + x_max) / 2;
            for (int i = 0; i < k; i++) {
                num += arr[i] / x;
            }
            if (num >= target) {
                find_x = x;
                x_min = x + 1;
            } else {
                x_max = x - 1;
            }
        }

        bw.write(find_x + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int start = Integer.parseInt(br.readLine());

        List<int[]>[] node = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            node[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int c = Integer.parseInt(inputs[2]);
            node[a].add(new int[]{b, c});
        }

        int[] toCost = new int[n + 1];
        Arrays.fill(toCost, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        q.add(new int[]{start, 0});
        toCost[start] = 0;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int from = tmp[0];
            int sum = tmp[1];

            if (sum > toCost[from])
                continue;

            for (int i = 0; i < node[from].size(); i++) {
                int to = node[from].get(i)[0];
                int sumover = sum + node[from].get(i)[1];
                if (toCost[to] > sumover) {
                    toCost[to] = sumover;
                    q.add(new int[]{to, sumover});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int a = toCost[i];
            sb.append(a == Integer.MAX_VALUE ? "INF" : a).append("\n");
        }
        System.out.println(sb.toString());
    }
}

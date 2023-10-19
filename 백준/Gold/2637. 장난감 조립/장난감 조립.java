import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<int[]>[] list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        int[] score = new int[N];
        int[] needCount = new int[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int b = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int t = Integer.parseInt(st.nextToken());
            list[b].add(new int[] { a, t });
            needCount[a]++;
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { N - 1, 1 });

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int sco = current[1];

            for (int[] next : list[x]) {
                int nx = next[0];
                int ns = next[1];

                score[nx] += sco * ns;
                
                needCount[nx]--;
                if (needCount[nx] == 0) {
                    q.add(new int[] { nx, score[nx] });
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (list[i].isEmpty()) {
                sb.append((i + 1) + " " + score[i] + "\n");
            }
        }

        System.out.println(sb);
    }
}

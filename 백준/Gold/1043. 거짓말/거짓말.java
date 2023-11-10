import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int nums = Integer.parseInt(st.nextToken());
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer>[] party = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            party[i] = new ArrayList<>();
            int tmp = Integer.parseInt(st.nextToken());
            for (int j = 0; j < tmp; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int cnt = m;
        boolean[] telling = new boolean[m];
        for (int x = 0; x < m; x++) {
            for (int i = 0; i < m; i++) {
                if (telling[i]) continue;
                boolean flag = false;
                for (int j = 0; j < party[i].size(); j++) {
                    if (set.contains(party[i].get(j))) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    telling[i] = true;
                    cnt--;
                    for (int j = 0; j < party[i].size(); j++) {
                        set.add(party[i].get(j));
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}

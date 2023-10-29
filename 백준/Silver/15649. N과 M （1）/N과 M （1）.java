import java.util.*;

public class Main {
    static StringBuilder sb;
    static int n, m;
    static boolean[] sel;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sb = new StringBuilder();
        sel = new boolean[n + 1];
        comb(0, new StringBuilder());
        System.out.println(sb.toString());
    }

    static void comb(int len, StringBuilder tmp) {
        if (len == m) {
            sb.append(tmp + "\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (sel[i]) continue;
            sel[i] = true;
            comb(len + 1, tmp.append(i + " "));
            sel[i] = false;
            tmp.delete(tmp.length() - 2, tmp.length());
        }
    }
}

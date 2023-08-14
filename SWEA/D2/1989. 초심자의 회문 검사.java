import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String word = br.readLine();
            List<Character> list = new ArrayList<>();

            for (int i = 0; i < word.length(); i++) {
                list.add(word.charAt(i));
            }

            int a = 1;
            for (int i = 0; i < list.size() / 2; i++) {
                if (list.get(i) == list.get(list.size() - 1 - i))
                    continue;
                a = 0;
            }

            System.out.println("#" + tc + " " + a);
        }
    }
}

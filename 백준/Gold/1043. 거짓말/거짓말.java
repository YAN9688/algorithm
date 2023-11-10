import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int nums = sc.nextInt();
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < nums; i++) {
			set.add(sc.nextInt());
		}
		List<Integer>[] party = new List[m];
		for (int i = 0; i < m; i++) {
			party[i] = new ArrayList<>();
			int tmp = sc.nextInt();
			for (int j = 0; j < tmp; j++) {
				party[i].add(sc.nextInt());
			}
		}
		boolean[] telling = new boolean[m];
		for (int x = 0; x < m; x++) {
			for (int i = 0; i < m; i++) {
				if (telling[i])
					continue;
				boolean flag = false;
				for (int j = 0; j < party[i].size(); j++) {
					if (set.contains(party[i].get(j))) {
						flag = true;
						break;
					}
				}
				if (flag) {
					telling[i] = true;
					for (int j = 0; j < party[i].size(); j++) {
						set.add(party[i].get(j));
					}
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			if (!telling[i])
				cnt++;
		}
		System.out.println(cnt);
	}
}
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextInt();
		long B = sc.nextInt();
		Queue<long[]> q = new LinkedList<>();
		q.add(new long[] { A, 1 });
		while (!q.isEmpty()) {
			long[] tmp = q.poll();

			long num = tmp[0];
			long time = tmp[1];
			long next_1 = num * 10 + 1;
			long next_2 = num * 2;
			if (next_1 == B || next_2 == B) {
				System.out.println(time + 1);
				return;
			}
			if (next_1 < B)
				q.add(new long[] { next_1, time + 1 });
			if (next_2 < B)
				q.add(new long[] { next_2, time + 1 });
		}
		System.out.println(-1);
	}

}

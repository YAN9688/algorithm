import java.util.*;
class Solution {
	public static HashSet<Integer> set;
	public static boolean[] visited;
	public static boolean check(int num) {
        if (num==2) return true;
        if (num % 2 == 0) return false;
		for (int i = 3; i*i <= num; i+=2) {
			if (num % i == 0) return false;
        }
		return true;
	} 
    public static void per(StringBuilder sb, String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(numbers.charAt(i));
                int num = Integer.parseInt(sb.toString());
                if (num >= 2 && check(num))
                    set.add(num);
                per(sb, numbers);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }
	public int solution(String numbers) {
		set=new HashSet<>();
        visited = new boolean[numbers.length()];
        StringBuilder sb=new StringBuilder();
		per(sb, numbers);
		return set.size();
    }
}
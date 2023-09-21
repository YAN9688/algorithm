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
	public static void per(String nu, String numbers) {
		for (int i = 0; i < numbers.length(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				per(nu + numbers.charAt(i), numbers);
				visited[i]= false;
			}			
		}
        if(nu.length()!=0){
            int num = Integer.parseInt(nu);
			if (num>=2 && check(num))
				set.add(num);
        }
	}
	public int solution(String numbers) {
		set=new HashSet<>();
        visited = new boolean[numbers.length()];
		per("", numbers);
		return set.size();
    }
}
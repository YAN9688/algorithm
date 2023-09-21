import java.util.*;


class Solution {
    //같은 숫자가 적힌 조각 제거 > set
	public static HashSet<Integer> set;
	public static boolean[] visited;
    //소수 체크, num이 3보다 큰 조건에만 들어옴, 연산 최소화를위해 i*i <= num
	public static boolean check(int num) {
		for (int i = 2; i*i <= num; i++) {
			if (num % i == 0) return false;
        }
		return true;
	} 
    //순열 메서드
	public static void per(String nu, String numbers, int len) {
		if (nu.length() == len) {
			int num = Integer.parseInt(nu);
			if (num>=2 && check(num))
				set.add(num);
			return;
		}
		for (int i = 0; i < numbers.length(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				per(nu + numbers.charAt(i), numbers, len);
				visited[i]= false;
			}
		}
	}
        //구현부
	public int solution(String numbers) {

		set=new HashSet<>();
        //고민했던부분: 원래 부분조합을 먼저 만들고 순서를 배열해줄지, 아래방법처럼할지 고민했는데 후자가 간단한 것 같아서 이렇게 함
		for (int len = 1; len <= numbers.length(); len++) {
			visited = new boolean[numbers.length()];
			per("", numbers, len);
		}
		return set.size();
    }
}
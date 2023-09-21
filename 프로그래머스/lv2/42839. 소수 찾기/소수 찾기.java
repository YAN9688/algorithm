import java.util.*;
class Solution {
    //같은 숫자가 적힌 조각과 첫자리가 0인 케이스 제거하기 위해 set 생성
	public static HashSet<Integer> set;
	public static boolean[] visited;
    // 소수 체크 메서드 
    // 순열 조건에서 num>=2 일 때만 들어옴, 연산 최소화를위해 i가 2일때 한번 체크해주고, i가 짝수일땐 확인해줄 필요가 없으므로 i+2, i*i <= num
	public static boolean check(int num) {
        if (num==2) return true;
        if (num % 2 == 0) return false;
		for (int i = 3; i*i <= num; i+=2) {
			if (num % i == 0) return false;
        }
		return true;
	} 
    //순열 구현 메서드
    //배열 안쓰고 그냥 빈 문자열을 만들고 이어붙이는 방식으로 했음
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
        //초기화
		set=new HashSet<>();
        visited = new boolean[numbers.length()];
        //고민했던부분: 원래 부분조합을 먼저 만들고 순서를 배열해줄지, 아래방법처럼할지 고민했는데 후자가 간단한 것 같아서 이렇게 함
		for (int len = 1; len <= numbers.length(); len++) {
			per("", numbers, len);
		}
		return set.size();
    }
}
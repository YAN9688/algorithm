class Solution {
	final static char[] kakao = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
	static int answer;
	static boolean[] sel;

	public int solution(int n, String[] data) {
		answer = 0;
		sel = new boolean[8];
		StringBuilder sb = new StringBuilder();
		per(sb, data);
		return answer;
	}

	static void per(StringBuilder sb, String[] data) {
		if (sb.length() == 8) {
			if (check(sb, data))
				answer++;
			return;
		}
		for (int i = 0; i < 8; i++) {
			if (!sel[i]) {
				sel[i] = true;
				per(sb.append(kakao[i]), data);
				sel[i] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	static boolean check(StringBuilder sb, String[] data) {
		String ordered = sb.toString();
		for (String condition : data) {
			char a = condition.charAt(0);
			char b = condition.charAt(2);
			char mark = condition.charAt(3);
			int dist = condition.charAt(4) - '0';
			int diff = Math.abs(ordered.indexOf(a) - ordered.indexOf(b))-1;
			if (mark == '<') {
				if (diff >= dist)
					return false;
			} else if (mark == '=') {
				if (diff != dist)
					return false;
			} else if (mark == '>') {
				if (diff <= dist)
					return false;
			}
		}
		return true;
	}
}
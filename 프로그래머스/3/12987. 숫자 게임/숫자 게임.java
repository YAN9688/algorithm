import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int N = A.length;
        for(int i=0; i<N; i++){
            if(A[answer]<B[i])
                answer++;
        }
        return answer;
    }
}
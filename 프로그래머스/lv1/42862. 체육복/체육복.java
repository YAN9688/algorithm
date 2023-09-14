import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int l=0;l<lost.length;l++){
            for(int r=0; r<reserve.length; r++){
                if(lost[l]==reserve[r]){
                    lost[l]=reserve[r]= -1;
                    answer++;
                    break;
                }
            }
        }
        for(int l:lost){
            for(int r=0; r<reserve.length; r++){
                if(l - 1==reserve[r] || l + 1==reserve[r]){
                    reserve[r]= -1;
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
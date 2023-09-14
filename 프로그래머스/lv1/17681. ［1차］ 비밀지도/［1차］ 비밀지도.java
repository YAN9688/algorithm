import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer =new String[n];
        for(int i=0; i< n;i++){
            int num = arr1[i]|arr2[i];
            String tmp=Integer.toBinaryString(num);
            if(tmp.length()<n){
                StringBuilder zeros = new StringBuilder();
                for(int j=0; j< n -tmp.length(); j++ ){
                    zeros.append("0");
                }
                tmp = zeros.toString()+tmp;
            }
            tmp= tmp.replace("1","#");
            tmp= tmp.replace("0"," ");
            answer[i]=tmp;
        }      
        return answer;
    }
}
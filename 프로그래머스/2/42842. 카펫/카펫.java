import java.util.*;
class Solution {
    static int ans1 = 0;
    static int ans2 = 0;
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        for(int i=sum;i>=1;i--){
            if(i<sum/i) break;
            if(sum%i==0){
                // System.out.println(i+" "+sum/i);
                // int width = i;
                // int height = sum/i;
                int tmpw = i*2;
                if(tmpw>brown) continue;
                else{
                    int tmph = yellow/(i-2);
                    if(tmpw + tmph * 2 == brown){
                        ans1 = i;
                        ans2 = sum/i;
                        break;
                    } 
                }
               
            }
        }
        answer[0] = ans1;
        answer[1] = ans2;
        return answer;
    }
}
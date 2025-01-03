import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n == 1) return 1;
        if(n % 2 == 0){
            while(true){
                if(n == 1) break;
                if(n % 2 != 0){
                    n--;
                    answer++;
                }
                else{
                    n/=2;
                }
            }
        }
        else{
            n--;
            answer++;
            while(true){
                if(n == 1) break;
                if(n % 2 != 0){
                    n--;
                    answer++;
                }
                else{
                    n/=2;
                }
            }
        }
        return answer+1;
    }
}
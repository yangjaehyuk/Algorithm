import java.util.*;
class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey!=0){
            int first = storey%10; //1의 자리
            int second = (storey/10)%10; // 10의 자리 
            if(first<5){
                answer+=first;
            }
            else if(first==5){
                if(second<5){
                    answer+=first;
                }
                else{
                    answer+=10-first;
                    storey+=10;
                }
            }
            else{
                answer+=10-first;
                storey+=10;
            }
            storey/=10;
        }
        return answer;
    }
}
import java.util.*;
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        // 참가자 번호 a, 경쟁자 번호 b
        while(a!=b){
            int check = 0;
            if(a%2 == 0){
                a /= 2;
                check++;
            }
            else{
                a ++;
                a /= 2;
                check++;
            }
            if(b%2 == 0){
                b /= 2;
                check++;
            }
            else{
                b ++;
                b /=2;
                check++;
            }
            if(check == 2) {
                answer++;
                n-=2;
            }
            
        }
        return answer;
    }
}
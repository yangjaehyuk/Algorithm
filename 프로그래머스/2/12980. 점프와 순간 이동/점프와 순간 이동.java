import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        if(n==1) return 1;
        if(n%2==0){
            while(true){
                if(n==1) break;
                if(n%2==0) n/=2;
                else{
                    n--;
                    ans++;
                    n/=2;
                }
            }
            ans++;
        }
        else{
            n--;
            ans++;
            while(true){
                if(n==1) break;
                if(n%2==0) n/=2;
                else{
                    n--;
                    ans++;
                    n/=2;
                }
            }
            ans++;
            
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println("Hello Java");

        return ans;
    }
}
import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String tmp = Integer.toString(n);
        char[] arr = tmp.toCharArray();
        for(int i=0;i<tmp.length();i++){
            answer+=arr[i]-'0';
        }

        return answer;
    }
}
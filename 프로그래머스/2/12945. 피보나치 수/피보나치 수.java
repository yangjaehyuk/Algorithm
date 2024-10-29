import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        if(n == 0) answer = 0;
        else if(n == 1) answer = 1;
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2;i<=n;i++){
            arr[i] = (arr[i-2] + arr[i-1]) % 1234567;
        }
        return arr[n];
    }
}
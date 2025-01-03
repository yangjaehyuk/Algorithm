import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        if(arr.length == 1) answer = arr[0];
        else{
            answer = arr[0];
            for(int i=1;i<arr.length;i++){
                int gcd = gcd(arr[i], answer);
                arr[i] /= gcd;
                answer *= arr[i];
            }
        }
        return answer;
    }
    
    public int gcd(int a, int b){
        if(a % b == 0) return b;
        return gcd(b, a % b);
    }
    
}
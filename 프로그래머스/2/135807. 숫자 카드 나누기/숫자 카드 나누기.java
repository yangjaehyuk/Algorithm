import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        boolean flagA = true;
        boolean flagB = true;
        int num1 = gcdgcd(arrayA); // arrayB에선 다 나누어 떨어지면 안됨
        int num2 = gcdgcd(arrayB); // arrayA에선 다 나누어 떨어지면 안됨
        if(num1 == 1){
            for(int i=0;i<arrayA.length;i++){
                if(arrayA[i] % num2 == 0){
                    flagB = false;
                    break;
                }
            }
            if(flagB) answer = num2;
            else answer = 0;
        }
        else if(num2 == 1){
            for(int i=0;i<arrayB.length;i++){
                if(arrayB[i] % num1 == 0){
                    flagA = false;
                    break;
                }
            }
            if(flagA) answer = num1;
            else answer = 0;
        }
        else{
            for(int i=0;i<arrayA.length;i++){
                if(arrayA[i] % num2 == 0){
                    flagB = false;
                    break;
                }
            }
            for(int i=0;i<arrayB.length;i++){
                if(arrayB[i] % num1 == 0){
                    flagA = false;
                    break;
                }
            }

            if(flagA == true && flagB == true) answer = Math.max(num1, num2);
            else if(flagA) answer = num1;
            else if(flagB) answer = num2;
            else answer = 0;
        }
        
        return answer;
    }
    
    private int gcdgcd(int[] arr){
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }
    private int gcd(int first, int second){
        if(first % second == 0) return second;
        return gcd(second, first % second);
    }
}
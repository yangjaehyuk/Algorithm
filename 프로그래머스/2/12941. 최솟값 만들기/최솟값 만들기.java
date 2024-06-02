import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        int[] NA = new int[A.length];
        int idx=0;
        for(int i=A.length-1;i>=0;i--){
            NA[idx] = A[i];
            idx++;
        }
        Arrays.sort(B);
        for(int i=0;i<A.length;i++){
            answer+=NA[i]*B[i];
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
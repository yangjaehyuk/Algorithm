import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)right - (int)left + 1];
        int idx = 0;
        List<Integer> list = new ArrayList<>();
        for(long i=left;i<=right;i++){
            int row = (int)(i/n);
            int col = (int)(i%n);
            int res = Math.max(row, col) + 1;
            answer[idx] = res;
            idx++;
        }
        return answer;
    }
}
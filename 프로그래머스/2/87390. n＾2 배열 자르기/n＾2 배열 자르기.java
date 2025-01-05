import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = {};
        List<Long> list = new ArrayList<>();
        for(long i=left;i<=right;i++){
            long row = i / n;
            long col = i % n;
            if(row >= col) list.add(row+1L);
            else{
                list.add(row+1L+(col-row));
            }
        }
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i).intValue();
        }
        return answer;
    }
}
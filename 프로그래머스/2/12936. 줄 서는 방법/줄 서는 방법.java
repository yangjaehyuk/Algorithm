import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = {};
        long f = 1;
        answer = new int[n];
        List<Integer> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            f *= i;
            list.add(i);
        }
        int idx = 0;
        k--;
        while(n > 0){
            f /= list.size();
            int val = (int)(k / f);
            answer[idx] = list.get(val);
            list.remove(val);
            k %= f;
            idx++;
            n --;
        }
        return answer;
    }
    
}
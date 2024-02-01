import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<d.length;i++){
            list.add(d[i]);
        }
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            if(answer+list.get(i)<=budget){
                answer+=list.get(i);
                cnt++;
            }
            else break;
            
        }
        return cnt;
    }
}
import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<tangerine.length;i++){
            list.add(tangerine[i]);
        }
        Collections.sort(list);
        for(Integer item: list){
            map.put(item, map.getOrDefault(item, 0)+1);
        }
        List<Integer> tmp = new ArrayList<>();
        for(Integer key: map.keySet()){
            tmp.add(map.get(key));
        }
        Collections.sort(tmp, Collections.reverseOrder());
        int sum = 0;
        int check = 0;
        for(Integer ans: tmp){
            if(sum >= k) break;
            else{
                sum += ans;
                check ++;
            }
        }
        return check;
    }
}
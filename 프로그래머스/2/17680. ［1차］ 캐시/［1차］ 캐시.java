import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        Deque<String> dq = new ArrayDeque<>();
        // cache hit 5
        // cache miss 1
        int answer = 0;
        String[] arr = new String[cities.length];
        int idx = 0;
        if(cacheSize==0){
            return 5*cities.length;
        }
        for(String city: cities){
            String c = city.toUpperCase();
            arr[idx++] = c;
        }
        for(int i=0;i<arr.length;i++){
            boolean check = true;
            if(dq.size()<cacheSize){
                if(dq.remove(arr[i])){
                    dq.add(arr[i]);
                    answer++;
                }
                else{
                    dq.add(arr[i]);
                    answer+=5;
                }
            }
            else{
                if(dq.remove(arr[i])){
                    dq.add(arr[i]);
                    answer++;
                }
                else{
                    dq.remove();
                    dq.add(arr[i]);
                    answer+=5;
                }
            }
        }
        
        return answer;
    }
}
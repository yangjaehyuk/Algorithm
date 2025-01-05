import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        for(int i=0;i<cities.length;i++){
            list.add(cities[i].toUpperCase());
        }
        List<String> dq = new ArrayList<>();
        if(cacheSize == 0) return cities.length * 5;
        for(int i=0;i<cities.length;i++){
            if(dq.size() < cacheSize){
                if(dq.indexOf(list.get(i)) < 0){
                    dq.add(list.get(i));
                    answer += 5;
                }
                else{
                    int index = dq.indexOf(list.get(i));
                    dq.remove(index);
                    dq.add(list.get(i));
                    answer++;
                }
            }
            else{
                // miss
                if(dq.indexOf(list.get(i)) < 0){
                    dq.remove(0);
                    dq.add(list.get(i));
                    answer += 5;
                }
                // hit
                else{
                    int index = dq.indexOf(list.get(i));
                    System.out.println(index);
                    dq.remove(index);
                    dq.add(list.get(i));
                    answer++;
                }
            }
        }
        return answer;
    }
}
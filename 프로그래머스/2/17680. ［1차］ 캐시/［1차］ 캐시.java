import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        // cache hit:1, cache miss: 5
        Deque<String> deque = new ArrayDeque<>();
        if(cacheSize == 0){
            answer += cities.length * 5;
        }
        else{
            for(String city: cities){
                city = city.toLowerCase();
                if(deque.size() < cacheSize){
                    if(deque.contains(city)){
                        deque.remove(city);
                        deque.add(city);
                        answer += 1;
                        }
                    else{
                        deque.add(city);
                        answer += 5;
                        }
                }
                else if(deque.size() == cacheSize){
                    if(deque.contains(city)){
                        deque.remove(city);
                        deque.add(city);
                        answer += 1;
                        }
                    else{
                        deque.remove();
                        deque.add(city);
                        answer += 5;
                        }
                    }
                }
        }
        return answer;
    }
}
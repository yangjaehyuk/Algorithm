import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        String answer = "";
        for(int i=0;i<participant.length;i++){
            if(map.containsKey(participant[i])){
                int value = map.get(participant[i]);
                map.put(participant[i],++value);
            }
            else{
                map.put(participant[i],1);
            }
        }
        for(String name: completion){
            if(map.containsKey(name)){
                int value = map.get(name);
                map.put(name, --value);
            }
        }
        for(String key: map.keySet()){
            if(map.get(key)!=0) answer=key;
        }
        return answer;
    }
}
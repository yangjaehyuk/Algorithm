import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
        HashMap<String, Integer> score = new HashMap<>();
        HashMap<String, Integer> ans = new HashMap<>();
        for(String name: friends){
            score.put(name, 0);
            map.put(name, new HashMap<String, Integer>());
            ans.put(name, 0);
        }
        for(int i=0;i<gifts.length;i++){
            int idx = gifts[i].indexOf(" ");
            String to = gifts[i].substring(0,idx);
            String from = gifts[i].substring(idx+1);
            int val1 = score.get(to);
            int val2 = score.get(from);
            score.put(to, ++val1);
            score.put(from, --val2);
        }
        for(int i=0;i<gifts.length;i++){
            int idx = gifts[i].indexOf(" ");
            String to = gifts[i].substring(0,idx);
            String from = gifts[i].substring(idx+1);
            map.get(to).put(from, map.get(to).getOrDefault(from,0)+1);
        }
        for(String to: map.keySet()){
            for(String from: map.keySet()){
                if(!to.equals(from)){
                    int giver = map.get(to).getOrDefault(from,0);
                    int receiver = map.get(from).getOrDefault(to,0);
                    if(giver>receiver){
                        int val = ans.get(to);
                        ans.put(to, val+=1);
                    }
                    else if(giver==receiver && score.get(to)>score.get(from)){
                        int val = ans.get(to);
                        ans.put(to, val+=1);
                    }
                }
            }
        }
        answer = Collections.max(ans.values());
        return answer;
    }
}
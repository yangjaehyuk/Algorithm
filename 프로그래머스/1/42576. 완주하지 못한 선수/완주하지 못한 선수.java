import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map=new HashMap();
        for(int i=0;i<participant.length;i++){
            if(map.get(participant[i])==null) map.put(participant[i],1);
            else{
                int val=map.get(participant[i])+1;
                map.put(participant[i],val);
            }
        }
        for(int i=0;i<completion.length;i++){
            int val=map.get(completion[i])-1;
            map.put(completion[i],val);
        }
        for(String s:map.keySet()){
            // System.out.println(map.get(s)+" "+s);
            if(map.get(s)==1){
                answer=s;
                break;
            }
        }
        return answer;
    }
}
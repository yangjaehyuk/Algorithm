import java.util.*;
class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> alpha = new HashMap<>();
        int idx = 65;
        for(int i=0;i<26;i++){
            char tmp = (char)idx;
            String keys = String.valueOf(tmp);
            alpha.put(keys, i+1);
            idx++;
        }
        
        int next = 27;
        int alphaIdx = 0;
        while(true){
            boolean flag = true;
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(alphaIdx));
            if(alphaIdx == msg.length()-1 && flag){
                list.add(alpha.get(sb.toString()));
                break;
            }
            if(alpha.containsKey(sb.toString())){
                while(true){
                    if(alphaIdx == msg.length()-1){
                        list.add(alpha.get(sb.toString()));
                        flag = false;
                        break;
                    }
                    alphaIdx++;
                    sb.append(msg.charAt(alphaIdx));
                    if(!alpha.containsKey(sb.toString())){
                        alpha.put(sb.toString(), next);
                        next++;
                        list.add(alpha.get(sb.toString().substring(0, sb.toString().length()-1)));
                        sb.setLength(0);
                        break;
                    }
                    
                }
                if(!flag) break;
                
            }
            
        }
                
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
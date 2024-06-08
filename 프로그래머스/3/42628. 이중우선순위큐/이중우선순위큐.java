import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        TreeSet<Integer> set = new TreeSet<>();
        for(String s: operations){
            if(s.charAt(0) == 'I'){
                StringBuilder sb = new StringBuilder();
                for(int i=2;i<s.length();i++){
                    sb.append(s.charAt(i));
                }
                int v = Integer.parseInt(sb.toString());
                set.add(v);
            }
            else{
                if(s.charAt(2) == '-'){
                    if(set.isEmpty()) continue;
                    set.pollFirst();
                }
                else{
                    if(set.isEmpty()) continue;
                    set.pollLast();
                }
            }
        }
        answer = new int[2];
        if(set.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }
        else{
            answer[0] = set.pollLast(); 
            answer[1] = set.pollFirst();
        }
        return answer;
    }
}
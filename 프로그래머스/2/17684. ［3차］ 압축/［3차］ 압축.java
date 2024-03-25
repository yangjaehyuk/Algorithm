import java.util.*;
class Solution {
    public static int idx = 0;
    public int[] solution(String msg) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        int num = 65;
        int plus = 27;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=1;i<27;i++){
            char alpha = (char)num;
            map.put(String.valueOf(alpha), i);
            num++;
        }
        while(true){
            int print = 0;
            StringBuilder sb = new StringBuilder();
            if(idx == msg.length()) break;
            for(int i=idx;i<msg.length();i++){
                sb.append(msg.charAt(i));
                if(map.containsKey(sb.toString()) == true){
                    print = map.get(sb.toString());
                    idx++;
                }
                else break;
            }
            map.put(sb.toString(), plus);
            plus++;
            list.add(print);
            print=0;
            sb.setLength(0);
        }
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
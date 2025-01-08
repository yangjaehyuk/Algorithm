import java.util.*;
class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int cri = 65;
        for(int i=1;i<=26;i++){
            map.put(String.valueOf((char)cri), i);
            cri++;
        }
        int last = 26;
        int idx = -1;
        boolean flag = false;
        while(true){
            if(flag) break;
            StringBuilder tmp = new StringBuilder();
            while(true){
                idx++;
                if(idx == msg.length()){
                    list.add(map.get(tmp.toString()));
                    flag = true;
                    break;
                }
                tmp.append(msg.charAt(idx));
                if(!map.containsKey(tmp.toString())){
                    last++;
                    map.put(tmp.toString(), last);
                    tmp.deleteCharAt(tmp.toString().length()-1);
                    list.add(map.get(tmp.toString()));
                    tmp.setLength(0);
                    idx--;
                    break;
                }
            }
        }
        System.out.println(idx);
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
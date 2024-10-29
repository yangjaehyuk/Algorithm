import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        String[] ans = s.split("\\s");
        // for(int i=0;i<ans.length;i++){
        //     System.out.println(ans[i]);
        // }
        for(int i=0;i<ans.length;i++){
            list.add(Integer.parseInt(ans[i]));
        }
        // for(Integer i: list){
        //     System.out.println(i);
        // }
        Collections.sort(list);
        sb.append(list.get(0));
        sb.append(" ");
        sb.append(list.get(list.size()-1));
        answer = sb.toString();
        return answer;
    }
}
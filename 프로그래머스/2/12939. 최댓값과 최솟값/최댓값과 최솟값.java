import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        boolean flag = false;
        List<Integer> ans = new ArrayList<>();
        for(String item: arr){
            int num = Integer.parseInt(item);
            ans.add(num);
        }
        Collections.sort(ans);
        answer+=ans.get(0);
        answer+=' ';
        answer+=ans.get(ans.size()-1);
        return answer;
    }
}
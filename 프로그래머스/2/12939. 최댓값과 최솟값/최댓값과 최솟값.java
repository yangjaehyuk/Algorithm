import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            ans.add(Integer.parseInt(arr[i]));
        }
        Collections.sort(ans);
        answer+=ans.get(0);
        answer+=' ';
        answer+=ans.get(ans.size() - 1);
        return answer;
    }
}
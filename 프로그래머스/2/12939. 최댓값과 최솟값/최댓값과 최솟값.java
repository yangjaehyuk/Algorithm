import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        List<Integer> lst = new ArrayList<>();
        String[] arr = s.split(" ");
        for(int i=0;i<arr.length;i++){
            lst.add(Integer.parseInt(arr[i]));
        }
        Collections.sort(lst);
        answer += lst.get(0);
        answer += ' ';
        answer += lst.get(lst.size()-1);
        return answer;
    }
}
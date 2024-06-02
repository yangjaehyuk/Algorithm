import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        String[] arr = s.split(" ");
        for(int i=0;i<arr.length;i++){
           list.add(Integer.parseInt(arr[i]));
        }
        Collections.sort(list);
        answer+=list.get(0);
        answer+=" ";
        answer+=list.get(list.size()-1);
        return answer;
    }
}
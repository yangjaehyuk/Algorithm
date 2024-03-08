import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        List<String> tmp = new ArrayList<>();
        for(int i: numbers){
            tmp.add(String.valueOf(i));
        }
        Collections.sort(tmp, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        for(String item: tmp){
            answer.append(item);
        }
        if(answer.charAt(0)=='0') return "0";
        return answer.toString();
    }
}
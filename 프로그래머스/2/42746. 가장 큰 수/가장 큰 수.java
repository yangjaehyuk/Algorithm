import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> list = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            list.add(String.valueOf(numbers[i]));
        }
        Collections.sort(list, new Comparator<>(){
           @Override
            public int compare(String s1, String s2){
                return Integer.parseInt(s2+s1) - Integer.parseInt(s1+s2); 
            }
        });
        for(String s: list){
            answer += s;
        }
        
        int cnt = 0;
        
        for(int i=0;i<answer.length()-1;i++){
            if(answer.charAt(i) == answer.charAt(i+1) && answer.charAt(i) == '0') cnt++;
        }
        
        if(cnt == answer.length() - 1) return "0";
        return answer;
    }
}
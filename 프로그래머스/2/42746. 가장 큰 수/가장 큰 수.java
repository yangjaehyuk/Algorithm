import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> list = new ArrayList<>();
        boolean flag = false;
        for(int i=0;i<numbers.length;i++){
            list.add(String.valueOf(numbers[i]));
            if(numbers[i] == 0) flag = true;
            else flag = false;
        }
        if(flag) return "0";
        Collections.sort(list, new Comparator<>() {
           @Override
            public int compare(String s1, String s2){
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        
        for(int i=0;i<list.size();i++){
            answer+=list.get(i);
        }
        return answer;
    }
}
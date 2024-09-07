import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        List<String> list = new ArrayList<String>();
        for(String s: phone_book){
            list.add(s);
        }
        Collections.sort(list);
        String cri = list.get(0);
        for(int i=1;i<list.size();i++){
            // System.out.println(list.get(i));
            if(list.get(i).startsWith(cri)) return false;
            cri = list.get(i);
        }
        return answer;
    }
}
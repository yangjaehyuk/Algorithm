import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        List<String> list = new ArrayList<>();
        for(int i=0;i<phone_book.length;i++){
            list.add(phone_book[i]);
        }
        Collections.sort(list);
        String cri = list.get(0);
        for(int i=1;i<phone_book.length;i++){
            if(list.get(i).startsWith(cri)) return false;
            cri = list.get(i);
        }
        return answer;
    }
}
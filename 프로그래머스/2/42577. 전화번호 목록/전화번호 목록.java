import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        String tmp = "a";
        Arrays.sort(phone_book);
        for(String item: phone_book){
            if(item.startsWith(tmp)){
                return false;
            }
            tmp = item;
        }
        return true;
    }
}
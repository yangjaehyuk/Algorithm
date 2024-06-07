import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = false;
        List<String> phones = new ArrayList<>();
        for(String s: phone_book){
            phones.add(s);
        }
        Collections.sort(phones);
        String tmp = "A";
        for(int i=0;i<phones.size();i++){
            if(phones.get(i).startsWith(tmp) == false){
                tmp = phones.get(i);
                answer = true;
            }
            else{
                answer = false;
                break;
            }
        }
        return answer;
    }
}
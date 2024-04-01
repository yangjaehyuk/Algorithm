import java.util.*;
class Solution {
    public String solution(int n) {
        // 1 2 4 -> 3
        // 11 12 14 21 22 24 41 42 44 -> 9
        // 3진법
        // 1 2 0 -> 0을 4로 바꾸기
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while(n>0){
            if(n%3==0){
                list.add(0,4);
                n/=3;
                n--;
            }
            else{
                list.add(0,n%3);
                n/=3;
            }
        }
        for(Integer item: list){
            sb.append(item);
        }
        return sb.toString();
    }
}
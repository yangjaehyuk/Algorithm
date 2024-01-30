import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        while(true){
            if(n==0) break;
            list.add(n%3);
            n/=3;
        }
        Collections.reverse(list);
        for(int i=list.size()-1;i>=0;i--){
            answer+=list.get(i)*Math.pow(3,i);
        }
        
        return answer;
    }
}
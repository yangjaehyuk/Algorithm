import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=number;i++){
            int tmp = 0;
            for(int j=1;j*j<=i;j++){
                if(j*j==i) tmp++;
                else if(i%j==0) tmp+=2;
            }
            if(tmp>limit) list.add(power);
            else list.add(tmp);
        }
        for(int item: list){
            answer+=item;
        }
        return answer;
    }
}
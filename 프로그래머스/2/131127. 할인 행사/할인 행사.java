import java.util.*;
class Solution {
    static int idx = 0;
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<want.length;i++){
            map.put(want[i], number[i]);
        }
        for(int i=0;i<discount.length-9;i++){
            Map<String, Integer> tmp = new HashMap<>();
            boolean check = true;
            for(int j=i;j<i+10;j++){
                // System.out.print(i+" "+j+" ");
                // 여기서 map에 있는 value가 다 0이 되는 지 확인
                if(tmp.containsKey(discount[j])==false){
                    tmp.put(discount[j],1);
                }
                else{
                    tmp.put(discount[j],tmp.get(discount[j])+1);
                }
                
            }
            // tmp와 map 비교
            for(int j=0;j<want.length;j++){
                if((tmp.get(want[j]) != map.get(want[j])) || (!tmp.containsKey(want[j]))){
                    check = false;
                    break;
                }
            }
            if(check) answer++;
            // System.out.println();
        }
        return answer;
    }
}
import java.util.*;
class Solution {
    // 발표한 논문 n편 중, 
    // h번 이상 인용된 논문이 h편 이상이고 
    // 나머지 논문이 h번 이하 인용되었다면 h의 최댓값
    static int maxi = 0;
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        if(citations[0] == citations[citations.length-1]) return 0;
        for(int i: citations){
            maxi = Math.max(maxi, i);
        }
        while(true){
            int upper = 0;
            int lower = 0;
            for(int j=0;j<citations.length;j++){
                if(citations[j]>=maxi) upper++;
            }
            if(upper>=maxi){
                // h번 이상 인용된 논문이 h편 이상이고
                for(int k=0;k<citations.length;k++){
                    if(citations[k]<=maxi){
                        lower++;
                    }
                }
                if(lower<=maxi){
                    // 나머지 논문이 h번 이하 인용되었다면 h의 최댓값
                    answer = maxi;
                    break;
                }
                else{
                    upper = 0;
                    lower = 0;
                    maxi--;
                }
            }
            else{
                upper = 0;
                lower = 0;
                maxi--;
            }
        }
        return answer;
    }
}
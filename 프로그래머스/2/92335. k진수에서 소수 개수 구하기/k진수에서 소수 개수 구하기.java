import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        // n을 k진수로 바꿨을 때
        String tmp = Integer.toString(n, k);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<tmp.length();i++){
            if(tmp.charAt(i) == '0'){
                if(sb.toString().length() == 0) continue;
                long cri = Long.parseLong(sb.toString());
                if(cri == 1) sb.setLength(0);
                else if(cri == 2) answer++;
                else{
                    for(long j=2;j*j<=cri;j++){
                        if(cri % j == 0) {
                            sb.setLength(0);
                            break;
                        }
                    }
                    if(sb.toString().length() > 0) answer++;
                }
                sb.setLength(0);
            }
            else{
                sb.append(tmp.charAt(i));
            }
        }
        if(sb.toString().length() > 0 &&Long.parseLong(sb.toString()) != 1){
            for(long j=2;j*j<=Long.parseLong(sb.toString());j++){
                if(Long.parseLong(sb.toString()) % j == 0) {
                    sb.setLength(0);
                    break;
                }
            }
            if(sb.toString().length() > 0) answer++;
        }
        return answer;
    }
}
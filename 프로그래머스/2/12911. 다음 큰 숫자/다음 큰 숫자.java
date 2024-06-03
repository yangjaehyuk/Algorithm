import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        String binaryN = Integer.toBinaryString(n);
        int Ncnt = 0;
        for(int i=0;i<binaryN.length();i++){
            if(binaryN.charAt(i)=='1') Ncnt ++;
        }
        while(true){
            n++;
            String tmpBinary = Integer.toBinaryString(n);
            int tmpCnt = 0;
            for(int j=0;j<tmpBinary.length();j++){
                if(tmpBinary.charAt(j)=='1') tmpCnt++;
            }
            if(Ncnt == tmpCnt){
                answer = n;
                break;
            }
            
        }
        return answer;
    }
}
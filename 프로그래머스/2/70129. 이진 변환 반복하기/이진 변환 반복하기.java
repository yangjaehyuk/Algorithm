import java.util.*;
class Solution {
    
    static int cnt = 0;
    static int zeroCnt = 0;
    public int[] solution(String s) {
        int[] answer = new int[2];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
        }
        while(true){
            List<Integer> list = new ArrayList<>();
            if(sb.toString().equals("1")) break;
            for(int j=0;j<sb.toString().length();j++){
                if(sb.toString().charAt(j) == '0'){
                    zeroCnt++;
                    list.add(j);
                }
            }
            for(int j=0;j<list.size();j++){
                if(j==0) sb.deleteCharAt(list.get(j));
                else sb.deleteCharAt(list.get(j)-j);
            }
            // System.out.println(zeroCnt);
            // 0제거후 길이를 2진법으로
            int size = sb.toString().length();
            sb.setLength(0);
            String tmp = Integer.toBinaryString(size);
            // System.out.println(tmp);
            for(int j=0;j<tmp.length();j++){
                sb.append(tmp.charAt(j));
            }
            cnt++;
            
        }
        answer[0] = cnt;
        answer[1] = zeroCnt;
        return answer;
    }
}
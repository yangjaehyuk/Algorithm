import java.util.*;
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = {};
        answer = new long[numbers.length];
        for(int i=0;i<numbers.length;i++){
            // System.out.println(Long.toString(numbers[i], 2));
            String cri = Long.toString(numbers[i], 2);
            cri = "0"+cri;
            char[] arr = cri.toCharArray();
            if(numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
                continue;
            }
            // 0이랑 1 교환
            int idx = 0;
            for(int j=arr.length-1;j>0;j--){
                if(arr[j] == '1' && arr[j-1] == '0'){
                    break;
                }
                idx++;
            }
            answer[i] = numbers[i] - (long)Math.pow(2, idx) + (long)Math.pow(2, (idx + 1));
        }
        return answer;
    }
}
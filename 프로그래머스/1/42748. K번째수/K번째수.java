import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];
        for(int i=0;i<commands.length;i++){
            int start = 0;
            int end = 0;
            int now = 0;
            for(int j=0;j<commands[i].length;j++){
                if(j == 0) start = commands[i][0] - 1;
                else if(j == 1) end = commands[i][1] - 1;
                else now = commands[i][2] - 1;
            }
            List<Integer> list = new ArrayList<>();
            for(int j=start;j<=end;j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[i] = list.get(now);
            
        }
        return answer;
    }
}
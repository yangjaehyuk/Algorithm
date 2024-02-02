import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        List<Integer> ans = new ArrayList<>();
        for(int[] command: commands){
            List<Integer> list = new ArrayList<>();
            int start = command[0];
            int end = command[1];
            int cri = command[2]-1;
            for(int i=start-1;i<end;i++){
                list.add(array[i]);
            }
            Collections.sort(list);
            // System.out.println(list.get(cri));
            ans.add(list.get(cri));
        }
        answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i]=ans.get(i);
        }
        return answer;
    }
}
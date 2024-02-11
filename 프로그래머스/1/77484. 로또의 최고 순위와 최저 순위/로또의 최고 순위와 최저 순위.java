import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> lottosList = new ArrayList<>();
        List<Integer> win_numsList = new ArrayList<>();
        for(int i=0;i<lottos.length;i++){
            lottosList.add(lottos[i]);
        }
        for(int i=0;i<win_nums.length;i++){
            win_numsList.add(win_nums[i]);
        }
        Collections.sort(lottosList);
        Collections.sort(win_numsList);
        int[] answer = new int[2];
        int min = 0;
        int max = 0;
        for(int i=0;i<lottos.length;i++){
            if(lottos[i]==0) max++;
        }
        for(int i=0;i<lottos.length;i++){
            if(win_numsList.contains(lottos[i])){
                max++;
                min++;
            }
        }
        if(min==6) min=1;
        else if(min==5) min=2;
        else if(min==4) min=3;
        else if(min==3) min=4;
        else if(min==2) min=5;
        else min=6;
        
        if(max==6) max=1;
        else if(max==5) max=2;
        else if(max==4) max=3;
        else if(max==3) max=4;
        else if(max==2) max=5;
        else max=6;
        answer[0]=max;
        answer[1]=min;
        return answer;
    }
}
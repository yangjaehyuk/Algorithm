import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        answer = new int[progresses.length];
        int maxi = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<progresses.length;i++){
            int tmp = (100 - progresses[i]) % speeds[i];
            if(tmp == 0){
                int days = (100 - progresses[i]) / speeds[i];
                if(days >= maxi){
                    maxi = days;
                    list.add(days);
                }
                else{
                    list.add(maxi);
                }
            }
            else{
                int days = (100 - progresses[i]) / speeds[i] + 1;
                if(days >= maxi){
                    maxi = days;
                    list.add(days);
                }
                else{
                    list.add(maxi);
                }
            }
            
        }
        int[] arr = new int[101];
        for(int i=0;i<list.size();i++){
            arr[list.get(i)]++;
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<101;i++){
            if(arr[i] > 0) ans.add(arr[i]);
        }
        answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
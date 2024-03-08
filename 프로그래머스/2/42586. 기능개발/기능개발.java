import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> pro = new ArrayList<>();
        List<Integer> speed = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        List<Integer> ansL = new ArrayList<>();
        for(int item: progresses){
            pro.add(item);
        }
        for(int item: speeds){
            speed.add(item);
        }
        for(int i=0;i<pro.size();i++){
            int start = pro.get(i);
            int cnt = 0;
            while(true){
                if(start >= 100) break;
                else{
                    start += speeds[i];
                    cnt++;
                }
            }
            tmp.add(cnt);
        }
        int tmpV = 0;
        for(Integer item: tmp){
            if(item > tmpV){
                tmpV = item;
                ans.add(item);
            }
            else{
                ans.add(tmpV);
            }
        }
        HashSet<Integer> hash = new HashSet<>(ans);
        List<Integer> lis = new ArrayList<>(hash);
        Collections.sort(lis);
        int idx = 0;
        for(Integer item: lis){
            System.out.println(item);
            ansL.add(Collections.frequency(ans, item));
        }
        // for(Integer item: ans){
        //     System.out.println(item);
        // }
        answer = new int[ansL.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=ansL.get(i);
        }
        return answer;
    }
}
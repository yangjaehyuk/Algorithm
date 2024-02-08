import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        HashMap<Integer,Double> list = new HashMap<>();
        for(int i=0;i<stages.length;i++){
            stages[i]-=1;
        }
        int len = stages.length;
        for(int j=0;j<N;j++){
            int sum=0;
            for(int i=0;i<stages.length;i++){
                if(j==stages[i]){
                    sum++;
                }
            }
            double res = (double)sum/len;
            if(len==0) res=0.0;
            list.put(j, res);
            len-=sum;
        }
        List<Integer> keys = new ArrayList<>(list.keySet());
        Collections.sort(keys, (o1, o2) -> (list.get(o2).compareTo(list.get(o1))));
        int idx=0;
        for(Integer key: keys){
            answer[idx]=key+1;
            idx++;
        }
        return answer;
    }
}
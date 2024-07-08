import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = {};
        List<Double> ans = new ArrayList<>();
        Map<Long, Integer> map = new HashMap<>();
        List<Double> list = new ArrayList<>();
        map.put(0L, k);
        long idx = 1;
        while(k != 1){
            if(k % 2 == 0){
                k /= 2;
                map.put(idx, k);
                idx++;
            }
            else{
                k *= 3;
                k++;
                map.put(idx, k);
                idx++;
            }
        }
        long n = idx - 1;
        for(long i = 0;i < map.size() - 1;i++){
            double mini = (double)Math.min(map.get(i), map.get(i+1));
            double maxi = (double)Math.max(map.get(i), map.get(i+1));
            double size = mini + (maxi - mini) / 2;
            list.add(size);
        }
        for(int i=0;i<ranges.length;i++){
            int[] tmp = ranges[i];
            int x = tmp[0];
            int y = tmp[1];
            double tmpv = 0.0;
            if(x == 0 && y == 0){
                for(int j=0;j<list.size();j++){
                    tmpv += list.get(j);
                }
                ans.add(tmpv);
            }
            else if(y <= 0){
                long tmpY = n - Math.abs(y);
                if(x > tmpY) ans.add(-1.0);
                else{
                    if(x == tmpY) ans.add(0.0);
                    else{
                        for(int j=x;j<tmpY;j++){
                            tmpv += list.get(j);
                        }
                        ans.add(tmpv);
                    }
                }
            }
            else if(x >= 0 && y >= 0){
                if(x == y) ans.add(0.0);
                else{
                    if(x < y) {
                        for(int j=x;j<y;j++){
                            tmpv += list.get(j);
                        }
                        ans.add(tmpv);
                    }
                    else ans.add(-1.0);
                }
            }
            
        }
        answer = new double[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
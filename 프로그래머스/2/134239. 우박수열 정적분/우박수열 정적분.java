import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = {};
        answer = new double[ranges.length];
        List<Integer> list = new ArrayList<>();
        List<Double> ans = new ArrayList<>();
        List<pair> now = new ArrayList<>();
        int n = 0;
        list.add(k);
        while(k!=1){
            if(k%2==0) k/=2;
            else k=k*3+1;
            list.add(k);
        }
        n = list.size();
        for(int i=0;i<list.size();i++){
            now.add(new pair(i, list.get(i)));
        }
        for(int i=0;i<now.size()-1;i++){
            int miny = Math.min(now.get(i).y, now.get(i+1).y);
            int maxy = Math.max(now.get(i).y, now.get(i+1).y);
            double square = miny;
            double triangle = (maxy - miny) / 2.0;
            ans.add(square + triangle);
        }
        for(int i=0;i<ranges.length;i++){
            double sum = 0.0;
            int x1 = ranges[i][0];
            int x2 = n - Math.abs(ranges[i][1]) - 1;
            if(x1 > x2) answer[i] = -1;
            else{
                for(int j=x1;j<x2;j++){
                    sum += ans.get(j);
                }
                answer[i] = sum;
            }
        }
        return answer;
    }
    public static class pair{
        int x;
        int y;
        pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
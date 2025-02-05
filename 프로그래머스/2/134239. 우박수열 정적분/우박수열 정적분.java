import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = {};
        answer = new double[ranges.length];
        List<Pair> list = new ArrayList<>();
        long num = 0;
        list.add(new Pair(num, k));
        while(true){
            if(k == 1){
                break;
            }
            if(k > 1){
                if(k % 2 == 0){
                    num++;
                    k/=2;
                    list.add(new Pair(num, k));
                }
                else{
                    num++;
                    k*=3;
                    k++;
                    list.add(new Pair(num, k));
                }
            }
        }
        // for(int i=0;i<list.size();i++){
        //     System.out.println(list.get(i).x+" "+list.get(i).y);
        // }
        List<Double> section = new ArrayList<>();
        for(int i=0;i<list.size() - 1;i++){
            double shortsero = Math.min(list.get(i).y, list.get(i+1).y) * 1.0;
            double longsero = Math.max(list.get(i).y, list.get(i+1).y) * 1.0;
            if(longsero == shortsero){
                section.add(longsero * 1);
            }
            else{
                section.add(shortsero * 1.0 + (longsero - shortsero) * 1 / 2.0);
            }
        }
        
        // for(int i=0;i<section.size();i++){
        //     System.out.println(section.get(i));
        // }
        
        for(int i=0;i<ranges.length;i++){
            double tmpv = 0.0;
            int x = ranges[i][0];
            int y = ranges[i][1];
            if(x == 0 && y == 0){
                for(int j=0;j<section.size();j++){
                    tmpv += section.get(j);
                }
                answer[i] = tmpv;
            }
            else if(y <= 0){
                long tmpY = num - Math.abs(y);
                if(x > tmpY) answer[i] = -1.0;
                else{
                    if(x == tmpY) answer[i] = 0.0;
                    else{
                        for(int j=x;j<tmpY;j++){
                            tmpv += section.get(j);
                        }
                        answer[i] = tmpv;
                    }
                }
            }
            else if(x >= 0 && y >= 0){
                if(x == y) answer[i] = 0.0;
                else{
                    if(x < y) {
                        for(int j=x;j<y;j++){
                            tmpv += section.get(j);
                        }
                        answer[i] = tmpv;
                    }
                    else answer[i] = -1.0;
                }
            }
        }
        return answer;
    }
    
    private class Pair{
        long x;
        int y;
        Pair(long x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
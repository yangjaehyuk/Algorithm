import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();
        for(int item: reserve){
            reserveSet.add(item);
        }
        for(int item: lost){
            if(reserveSet.contains(item)){
                reserveSet.remove(item);
            }
            else{
                lostSet.add(item);
            }
        }
        for(Integer item: reserveSet){
            if(lostSet.contains(item-1)){
                lostSet.remove(item-1);
            }
            else if(lostSet.contains(item+1)){
                lostSet.remove(item+1);
            }
        }
        answer=n-lostSet.size();
        return answer;
    }
}
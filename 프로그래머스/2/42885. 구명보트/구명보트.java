import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<people.length;i++){
            list.add(people[i]);
        }
        Collections.sort(list);
        int left = 0;
        int right = people.length - 1;
        while(true){
            if(left > right) break;
            else{
                if(list.get(left) + list.get(right) > limit){
                    right--;
                    answer++;
                }
                else{
                    left++;
                    right--;
                    answer++;
                }
            }
        }
        return answer;
    }
}
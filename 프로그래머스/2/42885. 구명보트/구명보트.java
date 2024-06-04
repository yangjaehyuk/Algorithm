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
        int right = list.size()-1;
        while(left<=right){
            int sum = list.get(right)+list.get(left);
            if(sum <= limit){
                answer++;
                left++;
                right--;
            }
            else{
                answer++;
                right--;
            }
        }
        return answer;
    }
}
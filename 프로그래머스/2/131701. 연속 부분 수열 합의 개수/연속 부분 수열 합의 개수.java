import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<elements.length;i++){
            for(int j=0;j<elements.length;j++){
                List<Integer> arr = new ArrayList<>();
                int sum = 0;
                for(int k=j;k<=i+j;k++){
                    int idx = k % elements.length;
                    arr.add(elements[idx]);
                }
                for(int k=0;k<arr.size();k++){
                    sum += arr.get(k);
                }
                set.add(sum);
            }
        }
        answer = set.size();
        return answer;
    }
}
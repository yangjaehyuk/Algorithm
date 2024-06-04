import java.util.*;
class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<elements.length;i++){
            list.add(elements[i]);
        }
        for(int i=1;i<=elements.length;i++){
            for(int j=0;j<elements.length;j++){
                int sum = 0;
                for(int k=j;k<i+j;k++){
                    // System.out.print(i+" "+j+" "+k+" ");
                    sum += elements[k%elements.length];
                }
                // System.out.println(sum);
                set.add(sum);
            }
        }
        answer = set.size();
        return answer;
    }
    
    
}
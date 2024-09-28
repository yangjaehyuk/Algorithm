import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            list1.add(A[i]);
        }
        for(int j=0;j<B.length;j++){
            list2.add(B[j]);
        }
        Collections.sort(list1);
        Collections.sort(list2, Collections.reverseOrder());
        int answer = 0;
        for(int i=0;i<list1.size();i++){
            answer += list1.get(i) * list2.get(i);
        }
        return answer;
    }
}
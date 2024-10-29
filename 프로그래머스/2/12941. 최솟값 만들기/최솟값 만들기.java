import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        List<Integer> lista = new ArrayList<>();
        List<Integer> listb = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            lista.add(A[i]);
        }
        for(int i=0;i<B.length;i++){
            listb.add(B[i]);
        }
        
        Collections.sort(lista);
        Collections.sort(listb, Collections.reverseOrder());
        
        for(int i=0;i<A.length;i++){
            answer += lista.get(i) * listb.get(i);
        }

        return answer;
    }
}
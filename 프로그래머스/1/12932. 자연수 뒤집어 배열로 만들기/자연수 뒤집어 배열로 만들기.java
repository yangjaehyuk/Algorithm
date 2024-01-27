import java.util.*;
class Solution {
    public int[] solution(long n) {
        List<Integer> intArr = new ArrayList<Integer>();
        String tmp = Long.toString(n);
        char[] arr = tmp.toCharArray();
        for(int i=tmp.length()-1;i>=0;i--){
            intArr.add(arr[i]-'0');
        }
        int[] answer = new int[intArr.size()];
        for(int i=0;i<intArr.size();i++){
            answer[i]=intArr.get(i);
        }
        return answer;
    }
}
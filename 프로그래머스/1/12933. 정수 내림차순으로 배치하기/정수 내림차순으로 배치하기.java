import java.util.*;

class Solution {
    public long solution(long n) {
        List<Integer> list = new ArrayList<>();
        String answer = "";
        String tmp = Long.toString(n);
        char[] charArr = tmp.toCharArray();
        for(int i=0;i<tmp.length();i++){
            list.add(charArr[i]-'0');
        }
        Integer[] arrInt = list.toArray(new Integer[0]);
        Arrays.sort(arrInt, Collections.reverseOrder());
        for(int i=0;i<tmp.length();i++){
            answer+=arrInt[i];
        }
        long ans = Long.parseLong(answer);
        return ans;
    }
}
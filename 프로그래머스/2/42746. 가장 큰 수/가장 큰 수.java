import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] ans = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            ans[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(ans, (a, b) -> (b + a).compareTo(a + b));

        for (String num : ans) {
            answer.append(num);
        }

        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer.toString();
    }
}

import java.util.*;

class Solution {
    public String solution(String p) {
        if (p.isEmpty()) {
            return "";
        }

        String[] separated = separate(p);
        String u = separated[0];
        String v = separated[1];

        if (isCorrect(u)) {
            return u + solution(v);
        } 
        else {
            StringBuilder newString = new StringBuilder();
            newString.append("("); // 4-1
            newString.append(solution(v)); // 4-2
            newString.append(")"); // 4-3

            u = u.substring(1, u.length() - 1);
            for (char c : u.toCharArray()) {
                newString.append(c == '(' ? ')' : '(');
            }
            // 4-5. 생성된 문자열 반환
            return newString.toString();
        }
    }

    private String[] separate(String temp) {
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        int left = 0, right = 0;

        for (int k = 0; k < temp.length(); k++) {
            if (temp.charAt(k) == '(') {
                left++;
            } else {
                right++;
            }
            u.append(temp.charAt(k));

            // 균형잡힌 괄호 문자열이 되었을 때 분리
            if (left == right) {
                v.append(temp.substring(k + 1));
                break;
            }
        }
        return new String[]{u.toString(), v.toString()};
    }

    private boolean isCorrect(String temp) {
        Stack<Character> stack = new Stack<>();
        for (char c : temp.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

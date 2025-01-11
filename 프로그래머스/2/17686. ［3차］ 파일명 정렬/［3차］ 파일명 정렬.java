import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        answer = new String[files.length];
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                s1 = s1.toUpperCase();
                s2 = s2.toUpperCase();
                
                String s1Head = "";
                String s2Head = "";
                
                int s1Number = 0;
                int s2Number = 0;
                for(int j=0;j<s1.length();j++){
                    if(Character.isDigit(s1.charAt(j))) break;
                    s1Head += s1.charAt(j);
                }
                
                for(int j=0;j<s2.length();j++){
                    if(Character.isDigit(s2.charAt(j))) break;
                    s2Head += s2.charAt(j);
                }
                // head 비교
                if(!s1Head.equals(s2Head)) return s1Head.compareTo(s2Head);
                else{
                    String tmp1 = "";
                    String tmp2 = "";
                    for(int k=s1Head.length();k<s1.length();k++){
                        if(!Character.isDigit(s1.charAt(k)) || tmp1.length()>=5) break;
                        tmp1+=s1.charAt(k);
                    }
                    for(int k=s2Head.length();k<s2.length();k++){
                        if(!Character.isDigit(s2.charAt(k)) || tmp2.length()>=5) break;
                        tmp2+=s2.charAt(k);
                    }
                    s1Number = Integer.parseInt(tmp1);
                    s2Number = Integer.parseInt(tmp2);
                    if(s1Number != s2Number) return s1Number - s2Number;
                    else {
                        // tail
                        return 0;
                    }
                }
            }         
        });
        for(int i=0;i<files.length;i++){
            answer[i] = files[i];
        }
        return answer;
    }
}
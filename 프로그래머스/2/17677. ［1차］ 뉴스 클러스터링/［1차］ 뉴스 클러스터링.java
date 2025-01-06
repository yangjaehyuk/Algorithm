import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        List<String> s1 = new ArrayList<>();
        List<String> s2 = new ArrayList<>();
        for(int i=0;i<str1.length()-1;i++){
            if(Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i+1))){
                String temp = str1.charAt(i)+""+str1.charAt(i+1);
                s1.add(temp);
            }
        }
        for(int i=0;i<str2.length()-1;i++){
            if(Character.isAlphabetic(str2.charAt(i)) && Character.isAlphabetic(str2.charAt(i+1))){
                String temp = str2.charAt(i)+""+str2.charAt(i+1);
                s2.add(temp);
            }
        }
        // 교집합
        List<String> gyo = new ArrayList<>();
        List<String> hap = new ArrayList<>();
        for(int i=0;i<s1.size();i++){
            if(s2.remove(s1.get(i))){
                gyo.add(s1.get(i));
            }
            hap.add(s1.get(i));
        }
        // 합집합
        for(int i=0;i<s2.size();i++){
            hap.add(s2.get(i));
        }
        int hapL = hap.size();
        double gyoL = gyo.size();
        if(gyoL == 0 || hapL == 0) answer = 65536;
        if(gyoL == 0 && hapL == 0) answer = 65536;
        else{
            double res = gyoL / hapL;
            double temp = res * 65536;
            answer = (int)temp;
        }
        return answer;
    }
}
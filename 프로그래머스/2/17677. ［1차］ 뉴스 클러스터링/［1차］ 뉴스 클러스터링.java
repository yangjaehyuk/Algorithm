import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> Only1 = new ArrayList<>();
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        for(int i=0;i<str1.length()-1;i++){
            StringBuilder sb = new StringBuilder();
            if('A'<=str1.charAt(i) && str1.charAt(i)<='Z' && 'A'<=str1.charAt(i+1) && str1.charAt(i+1)<='Z'){
                sb.append(str1.charAt(i));
                sb.append(str1.charAt(i+1));
                list.add(sb.toString());
                list1.add(sb.toString());
                Only1.add(sb.toString());
                
            }
        }
        for(int i=0;i<str2.length()-1;i++){
            StringBuilder sb = new StringBuilder();
            if('A'<=str2.charAt(i) && str2.charAt(i)<='Z' && 'A'<=str2.charAt(i+1) && str2.charAt(i+1)<='Z'){
                sb.append(str2.charAt(i));
                sb.append(str2.charAt(i+1));
                list.add(sb.toString());
                list2.add(sb.toString());
            }
        }
        int gop = 0;
        int hap = 0;
        for(String s: list2){
            Only1.remove(s);
        }
        // for(String s: Only1){
        //     System.out.println(s);
        // }
        gop = list1.size() - Only1.size();
        hap = list2.size() + Only1.size();
        // System.out.println(gop+" "+hap);
        double bunja = gop;
        double bunmo = hap;
        if(bunja==0.0 && bunmo == 0.0) return 65536;
        double ans = bunja/bunmo;
        answer = (int)(ans * 65536);
        // System.out.println(bunja+" "+bunmo+" "+ans+" "+ans*65536);
        return answer;
    }
}
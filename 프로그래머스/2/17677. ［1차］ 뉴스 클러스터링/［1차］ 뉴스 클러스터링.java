import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        int cri = 65536;
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        List<String> res1 = new ArrayList<>();
        List<String> res2 = new ArrayList<>();
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        for(char item: arr1){
            list1.add(item);
        }
        for(char item: arr2){
            list2.add(item);
        }
        for(int i=0;i<list1.size()-1;i++){
            boolean check = false;
            String tmp = Character.toString(list1.get(i)) + Character.toString(list1.get(i+1));
            tmp = tmp.toLowerCase();
            for(int k=0;k<2;k++){
                if(!Character.isAlphabetic(tmp.charAt(k))){
                    check = true;
                    break;
                }
            }
            if(check == false) res1.add(tmp);
        }
        for(int j=0;j<list2.size()-1;j++){
            boolean check = false;
            String tmp = Character.toString(list2.get(j)) + Character.toString(list2.get(j+1));
            tmp = tmp.toLowerCase();
            for(int k=0;k<2;k++){
                if(!Character.isAlphabetic(tmp.charAt(k))){
                    check = true;
                    break;
                }
            }
            if(check == false) res2.add(tmp);
        }
        int len1 = res1.size();
        int len2 = res2.size();
        List<String> gyo = new ArrayList<>();
        List<String> hap = new ArrayList<>();
        if(len1 < len2){
            for(String item: res1){
                if(res2.remove(item)){
                    gyo.add(item);
                }
                hap.add(item);
            }
            for(String item: res2){
                hap.add(item);
            }
        }
        else{
            for(String item: res2){
                if(res1.remove(item)){
                    gyo.add(item);
                }
                hap.add(item);
            }
            for(String item: res1){
                hap.add(item);
            }
        }
        double hLen = hap.size();
        double gLen = gyo.size();
        if(hLen == 0){
            return cri;
        }
        else{
            double tmp = gLen / hLen;
            answer = (int)(cri * tmp);
            return answer;
        }
    }
}
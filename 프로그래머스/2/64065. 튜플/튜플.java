import java.util.*;
class Solution {
    static boolean check = true;
    static StringBuilder sb = new StringBuilder();
    public int[] solution(String s) {
        int[] answer = {};
        List<Integer> ansL = new ArrayList<>();
        List<String> list = new ArrayList<>();
        s = s.substring(1, s.length()-1);
        // System.out.println(s);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='{'){
                check = false;
            }
            else if(s.charAt(i)=='}'){
                list.add(sb.toString());
                sb.setLength(0);
                check = true;
            }
            else{
                if(!check){
                    sb.append(s.charAt(i));
                }
            }
        }
        list.sort(new Comparator<>(){
            @Override
            public int compare(String s1, String s2){
                return s1.length() - s2.length();
            }
        });
        answer = new int[list.size()];
        // System.out.println(list.size());
        for(String str: list){
            // System.out.println(str.length()+" "+str);
            String[] strA = str.split(" ");
            // System.out.println(strA.length);
            StringBuilder sb2 = new StringBuilder();
            for(int j=0;j<strA.length;j++){
                // System.out.println(strA[j]);
                sb2.append(strA[j]);
            }
            String[] deepA = sb2.toString().split(",");
            for(int j=0;j<deepA.length;j++){
                boolean checking = true;
                // System.out.println(deepA[j]);
                int tmpV = Integer.parseInt(deepA[j]);
                if(ansL.size()==0) ansL.add(tmpV);
                else{
                    for(int k=0;k<ansL.size();k++){
                        if(ansL.get(k) == tmpV) {
                            checking = false;
                            break;
                        }
                    }
                    if(checking){
                        
                        ansL.add(tmpV);
                    }
                }
                
            }
            
        }
        for(Integer i: ansL){
            System.out.println(i);
        }
        for(int i=0;i<answer.length;i++){
            answer[i] = ansL.get(i);
        }
        return answer;
    }
}
import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        boolean check=true;
        List<String> list = new ArrayList<>();
        List<String> c1 = new ArrayList<>();
        List<String> c2 = new ArrayList<>();
        List<Integer> c1Ans = new ArrayList<>();
        List<Integer> c2Ans = new ArrayList<>();
        for(int i=0;i<goal.length;i++){
            list.add(goal[i]);
        }
        for(int i=0;i<cards1.length;i++){
            c1.add(cards1[i]);
        }
        for(int i=0;i<cards2.length;i++){
            c2.add(cards2[i]);
        }
        for(int i=0;i<goal.length;i++){
            if(c1.contains(list.get(i))){
                for(int j=0;j<c1.size();j++){
                    if(c1.get(j).equals(list.get(i))){
                        c1Ans.add(j);
                    }
                }
            }
            else if(c2.contains(list.get(i))){
                for(int j=0;j<c2.size();j++){
                    if(c2.get(j).equals(list.get(i))){
                        c2Ans.add(j);
                    }
                }
            }
        }
        for(int i=0;i<c1Ans.size();i++){
            System.out.println(c1Ans.get(i));
        }
        for(int i=0;i<c2Ans.size();i++){
            System.out.println(c2Ans.get(i));
        }
        if(c1Ans.size()==1) check=true;
        else{
            for(int i=0;i<c1Ans.size()-1;i++){
                if(c1Ans.get(i)>c1Ans.get(i+1)){
                    check=false;
                    break;
                }
                else if(c1Ans.get(i)+1!=c1Ans.get(i+1)){
                    check=false;
                    break;
                }
            }
        }
        
        for(int i=0;i<c2Ans.size()-1;i++){
            if(c2Ans.get(i)>c2Ans.get(i+1)){
                check=false;
                break;
            }
            else if(c2Ans.get(i)+1!=c2Ans.get(i+1)){
                check=false;
                break;
            }
        }
        if(check==false) answer="No";
        else answer="Yes";
        return answer;
    }
}
import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String s: skill_trees){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<s.length();i++){
                if(skill.indexOf(s.charAt(i)) != -1) list.add(skill.indexOf(s.charAt(i)));
            }
            System.out.println(list.size());
            
            if(list.size() == 0){
                answer++;
            }
            else if(list.size() == 1){
                for(Integer it: list){
                    if(it == 0) answer++;
                }
            }
            else{
                boolean check = true;
                if(list.get(0) != 0) check = false;
                else{
                    for(int j=0;j<list.size()-1;j++){
                        if(list.get(j)+1 != list.get(j+1)){
                            check = false;
                            break;
                        }
                    }
                }
                
                if(check) answer++;
            }
        }
        return answer;
    }
}
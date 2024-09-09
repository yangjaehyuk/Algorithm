import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i=0;i<skill_trees.length;i++){
            String skillSet = skill_trees[i];
            List<Integer> idx = new ArrayList<>();
            List<Character> list = new ArrayList<>();
            boolean flag = true;
            for(int j=0;j<skill.length();j++){
                if(skillSet.indexOf(skill.charAt(j)) != -1) idx.add(skillSet.indexOf(skill.charAt(j)));
            }
            Collections.sort(idx);
            for(Integer it: idx){
                list.add(skillSet.charAt(it));
            }
            StringBuilder sb = new StringBuilder();
            for(Character c: list){
                sb.append(c);
            }
            String tmp = sb.toString();
            System.out.println(tmp);
            if(skill.startsWith(tmp)){
                answer++;
            }
                   
        }
        
        return answer;
    }
}
import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i=0;i<skill_trees.length;i++){
            List<Character> list = new ArrayList<>();
            boolean flag = true;
            for(int j=0;j<skill_trees[i].length();j++){
                if (skill.indexOf(skill_trees[i].charAt(j)) != -1) {
                    list.add(skill_trees[i].charAt(j));
                }
            }
            
            for(int j=0;j<list.size();j++){
                if(list.get(j) != skill.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        return answer;
    }
}
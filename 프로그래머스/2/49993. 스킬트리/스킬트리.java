import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char[] arr = skill.toCharArray();
        for(int i=0;i<skill_trees.length;i++){
            List<Integer> process = new ArrayList<>();
            boolean check = true;
            for(int j=0;j<skill_trees[i].length();j++){
                char nowSkill = skill_trees[i].charAt(j);
                if(skill.indexOf(nowSkill) != -1) {
                    process.add(skill.indexOf(nowSkill));
                }
            }
            System.out.println(process);
            for(int j=0;j<process.size();j++){
                if(j != process.get(j)){
                    check = false;
                    break;
                }
            }
            if(check) answer++;
            // System.out.println(check);
        }
        return answer;
    }
}
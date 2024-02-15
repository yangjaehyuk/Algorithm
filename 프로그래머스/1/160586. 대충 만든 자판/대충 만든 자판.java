import java.util.*;
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        for(int i=0;i<targets.length;i++){
            int total = 0;
            int cnt = 0;
            for(int j=0;j<targets[i].length();j++){
                char tar = targets[i].charAt(j);
                List<Integer> list = new ArrayList<>();
                for(int k=0;k<keymap.length;k++){
                    for(int l=0;l<keymap[k].length();l++){
                        char cri = keymap[k].charAt(l);
                        if(tar==cri){
                            int turn = l+1;
                            list.add(turn);
                        }
                    }
                }
                Collections.sort(list);
                for(int k=0;k<list.size();k++){
                    total+=list.get(0);
                    cnt++;
                    break;
                }
            }
            if(total==0 || cnt!=targets[i].length()) answer[i]=-1;
            else answer[i]=total;
        }
        return answer;
    }
}
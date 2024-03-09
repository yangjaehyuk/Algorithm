import java.util.*;
class Solution {
    static int num = 0;
    static char[] path = new char[5];
    static char[] tmp = {'A', 'E', 'I', 'O', 'U'};
    static ArrayList<String> list;
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        for(int i=1;i<=5;i++){
            char[] path = new char[5];
            dfs(tmp, word, 0, i, path);
        }
        Collections.sort(list);
        answer = list.indexOf(word)+1;
        return answer;
    }
    public void dfs(char[] tmp, String word, int lev, int level, char[] path){
        StringBuilder sb = new StringBuilder();
        if(lev==level){
            num++;
            for(int i=0;i<lev;i++){
                sb.append(path[i]);
            }
            list.add(sb.toString());
            return;
        }
        for(int i=0;i<5;i++){
            path[lev] = tmp[i];
            dfs(tmp, word, lev+1, level, path);
        }
    }
}
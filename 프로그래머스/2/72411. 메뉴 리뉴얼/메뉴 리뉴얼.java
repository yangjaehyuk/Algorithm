import java.util.*;
class Solution {
    static char[] path;
    static boolean[] visited;
    static Map<String, Integer> map = new HashMap<>();
    static List<String> ans;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        for(int i=0;i<orders.length;i++){
            path = new char[orders[i].length()];
            visited = new boolean[orders[i].length()];
            for(int j=0;j<course.length;j++){
                int cri = course[j];
                if(orders[i].length() < cri) break;
                char[] first = orders[i].toCharArray();
                Arrays.sort(first);
                String done = new String(first);
                dfs(0, course[j], 0, done);
            }
        }
        Set<String> set = new HashSet<>();
        for(int i=0;i<course.length;i++){
            int maxi = 0;
            for(String key: map.keySet()){
                if(course[i] == key.length()) maxi = Math.max(map.get(key), maxi);
            }
            if(maxi > 1){
                for(String key: map.keySet()){
                    if(maxi == map.get(key) && course[i] == key.length()){
                        set.add(key);
                    }
                }
            }
        }
        ans = new ArrayList<>(set);
        Collections.sort(ans);
        answer = new String[set.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = ans.get(i);
        }
        return answer;
        
    }
    
    private void dfs(int lev, int level, int start, String tmp){
        if(lev == level){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<lev;i++){
                sb.append(path[i]);
            }
            if(!map.containsKey(sb.toString())){
                map.put(sb.toString(), 1);
            }
            else{
                int val = map.get(sb.toString()) + 1;
                map.put(sb.toString(), val);
            }
            return;
        }
        for(int i=start;i<tmp.length();i++){
            path[lev] = tmp.charAt(i);
            dfs(lev+1, level, i+1, tmp);
            path[lev] = 0;
        }
    }
}
import java.util.*;
class Solution {
    public static boolean[] visited;
    public static int[] dis;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[words.length];
        dis = new int[words.length + 1];
        boolean check = false;
        for(String str: words){
            if(str.equals(target)){
                check = true;
                break;
            }
        }
        if(check == false){
            return 0;
        }
        else{
            q.add(new Node(begin, 0));
            while(!q.isEmpty()){
                Node now = q.poll();
                if(now.begin.equals(target)){
                    break;
                }
                for(int j=0;j<words.length;j++){
                    int cnt = 0;
                    if(visited[j] == true){
                        continue;
                    }
                    else{
                        for(int k=0;k<now.begin.length();k++){
                            if(now.begin.charAt(k) == words[j].charAt(k)){
                                cnt++;
                            }
                        }
                        if(cnt == now.begin.length()-1){
                            visited[j] = true;
                            q.add(new Node(words[j], j+1));
                            dis[j+1] = dis[now.idx] + 1;
                            answer = dis[j+1];
                        }
                    }
                }
            }
        }
        return answer;
    }
    class Node{
        String begin;
        int idx;
        public Node(String begin, int idx){
            this.begin = begin;
            this.idx = idx;
        }
    }
}
import java.util.*;
class Solution {
    public static boolean[][] visited;
    public int[] solution(String[] maps) {
        int[] answer = {};
        int[] dx={0,0,1,-1};
        int[] dy={1,-1,0,0};
        visited = new boolean[maps.length][maps[0].length()];
        Queue<Pair> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(Character.isDigit(maps[i].charAt(j)) && visited[i][j] == false){
                    int sum = maps[i].charAt(j)-'0';
                    q.add(new Pair(i,j));
                    visited[i][j]=true;
                    while(!q.isEmpty()){
                        Pair test = q.poll();
                        int nowx = test.x;
                        int nowy = test.y;
                        for(int k=0;k<4;k++){
                            int nx = nowx+dx[k];
                            int ny = nowy+dy[k];
                            if(nx<0 || ny<0 || nx>=maps.length || ny>=maps[0].length()||visited[nx][ny]==true || maps[nx].charAt(ny)=='X') continue;
                            else{
                                sum+=maps[nx].charAt(ny)-'0';
                                visited[nx][ny]=true;
                                q.add(new Pair(nx, ny));
                            }
                        }
                    }
                    list.add(sum);
                }
            }
        }
        Collections.sort(list);
        if(list.size()==0){
            answer = new int[1];
            answer[0] = -1;
        }
        else{
            answer = new int[list.size()];
            for(int i=0;i<list.size();i++){
                answer[i] = list.get(i);
            }
        }
        
        return answer;
    }
    public static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
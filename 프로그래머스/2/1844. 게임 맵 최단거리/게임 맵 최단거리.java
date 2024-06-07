import java.util.*;
class Solution {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] copied = new int[maps.length][maps[0].length];
        for(int j=0;j<maps.length;j++){
            for(int k=0;k<maps[j].length;k++){
                copied[j][k] = 0;
            }
        }
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            visited[x][y] = true;
            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && ny>=0 && nx<maps.length && ny<maps[0].length && maps[nx][ny] == 1 && !visited[nx][ny]){
                    copied[nx][ny] = copied[x][y] + 1;
                    visited[nx][ny] = true;
                    q.add(new Pair(nx, ny));
                }
            }
        }
        // for(int j=0;j<maps.length;j++){
        //     for(int k=0;k<maps[j].length;k++){
        //         System.out.print(copied[j][k]);
        //     }
        //     System.out.println();
        // }
        if(!visited[maps.length-1][maps[0].length-1]) answer = -1;
        else answer = copied[maps.length-1][maps[0].length-1] + 1;
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
import java.util.*;
class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited = new boolean[101][101];
    public int solution(int[][] maps) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0));
        visited[0][0] = true;
        int n = maps.length;
        int m = maps[0].length;
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int i=0;i<4;i++){
                int nx = now.row + dx[i];
                int ny = now.col + dy[i];
                if(nx>=0 && nx<maps.length && ny>=0 && ny<maps[0].length && visited[nx][ny] == false && maps[nx][ny] == 1){
                    visited[nx][ny] = true;
                    maps[nx][ny] = maps[now.row][now.col]+1;
                    q.add(new Node(nx, ny));
                }
            }
        }
        // for(int i=0;i<maps.length;i++){
        //     for(int j=0;j<maps[0].length;j++){
        //         System.out.print(maps[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        if(visited[maps.length-1][maps[0].length-1] == false) answer = -1;
        else answer = maps[maps.length-1][maps[0].length-1];
        return answer;
    }
    class Node{
        int row;
        int col;
        public Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}
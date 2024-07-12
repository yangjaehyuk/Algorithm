
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int[][] arr;
    static int[] dx = {1, 0, -1 ,0};
    static int[] dy = {0, -1, 0, 1};
    static int mini = 99999999;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i=0;i<n;i++){
            String[] tmp = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        int cnt = 2;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    bfs(i, j, n, cnt);
                    cnt++;
                }
            }
        }

        for(int i=2;i<cnt;i++){
            findShortestBridge(i, n);
        }

        System.out.println(mini);


    }

    public static void bfs(int sx, int sy, int n, int cnt){
        Queue<Pair> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.add(new Pair(sx, sy));
        visited[sx][sy] = true;
        arr[sx][sy] = cnt;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;

            for(int i=0;i<4;i++){

                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<n && !visited[nx][ny] && arr[nx][ny]==1){
                    visited[nx][ny] = true;
                    arr[nx][ny] = cnt;
                    q.add(new Pair(nx, ny));
                }
            }

        }
    }


    public static void findShortestBridge(int currentIsland, int n) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == currentIsland) {
                    queue.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int distance = node.bridge;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    if (arr[nx][ny] != 0 && arr[nx][ny] != currentIsland) {
                        mini = Math.min(mini, distance);
                        return;
                    }
                    if (arr[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny, distance + 1));
                    }
                }
            }
        }
    }

    public static class Node{
        int x;
        int y;
        int bridge;

        Node(int x, int y, int bridge){
            this.x = x;
            this.y = y;
            this.bridge = bridge;
        }
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
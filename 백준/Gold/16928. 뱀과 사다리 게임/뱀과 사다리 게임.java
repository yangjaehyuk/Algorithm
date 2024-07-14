import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int[] map = new int[101];
    static boolean[] visited = new boolean[101];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] docs = br.readLine().split(" ");
        for(int i=1;i<=100;i++){
            map[i] = 0;
        }
        int line = Integer.parseInt(docs[0]);
        int snake = Integer.parseInt(docs[1]);
        for(int i=0; i<line; i++){
            String tmp[] = br.readLine().split(" ");
            int start = Integer.parseInt(tmp[0]);
            int end = Integer.parseInt(tmp[1]);
            map[start] = end;
        }
        for(int i=0; i<snake; i++){
            String tmp[] = br.readLine().split(" ");
            int start = Integer.parseInt(tmp[0]);
            int end = Integer.parseInt(tmp[1]);
            map[start] = end;
        }
        bfs(1);
    }

    public static void bfs(int start){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));
        visited[start] = true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int cur = p.now;
            int cnt = p.cnt;
            if(cur >= 100){
                System.out.println(cnt);
                return;
            }
            for(int i=1; i<=6; i++){
                int ncur = cur + i;
                if(ncur <= 100 && !visited[ncur]){
                    if(map[ncur] > 0) ncur = map[ncur];
                    visited[ncur] = true;
                    q.add(new Pair(ncur, cnt+1));
                }
            }
        }

    }

    public static class Pair{
        int now;
        int cnt;
        public Pair(int now, int cnt){
            this.now = now;
            this.cnt = cnt;
        }
    }
}

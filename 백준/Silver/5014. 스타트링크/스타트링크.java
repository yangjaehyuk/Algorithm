import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int w;
    public static int h;
    public static int[] dx = {1, -1};
    public static int[] arr;
    public static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] docs = br.readLine().split(" ");
        int f = Integer.parseInt(docs[0]);
        int s = Integer.parseInt(docs[1]);
        int g = Integer.parseInt(docs[2]);
        int u = Integer.parseInt(docs[3]);
        int d = Integer.parseInt(docs[4]);
        int ups = u * dx[0];
        int dos = d * dx[1];
        arr = new int[f + 1];
        visited = new boolean[f + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        arr[s] = 1;
        while(!q.isEmpty()){
            int now = q.poll();
            if(now + ups <= f && !visited[now + ups]){
                q.add(now + ups);
                visited[now + ups] = true;
                arr[now + ups] = arr[now] + 1;
            }
            
            if(now + dos > 0 && !visited[now + dos]){
                q.add(now + dos);
                visited[now +dos] = true;
                arr[now + dos] = arr[now] + 1;
            }
        }
        if(!visited[g]) System.out.println("use the stairs");
        else System.out.println(arr[g] - 1);
    }
    
}

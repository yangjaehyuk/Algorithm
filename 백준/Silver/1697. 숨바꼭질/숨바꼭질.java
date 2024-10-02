import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int w;
    public static int h;
    public static int[] dx = {1, 1, 2};
    public static int[] arr;
    public static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] docs = br.readLine().split(" ");
        int start = Integer.parseInt(docs[0]);
        int end = Integer.parseInt(docs[1]);
        arr = new int[100001];
        visited = new boolean[100001];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        arr[start] = 0;
        visited[start] = true;
        
        while(!q.isEmpty()){
            int p = q.poll();
            if(p + dx[0] < 100001 && !visited[p + dx[0]]){
                visited[p + dx[0]] = true;
                arr[p + dx[0]] = arr[p] + 1;
                q.add(p + dx[0]);
            }
            
            if(p - dx[1] >= 0 && !visited[p - dx[1]]){
                visited[p - dx[1]] = true;
                arr[p - dx[1]] = arr[p] + 1;
                q.add(p - dx[1]);
            }
            
            if(p * dx[2] <= 100000 && !visited[p * dx[2]]){
                visited[p * dx[2]] = true;
                arr[p * dx[2]] = arr[p] + 1;
                q.add(p * dx[2]);
            }
        }
        
        
        System.out.println(arr[end]);
        
    }
    
}

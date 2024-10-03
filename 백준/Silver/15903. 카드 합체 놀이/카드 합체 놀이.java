import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] docs = br.readLine().split(" ");
        int n = Integer.parseInt(docs[0]);
        int m = Integer.parseInt(docs[1]);
        PriorityQueue<Long> pq = new PriorityQueue<>();
        String[] tmp = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            pq.offer(Long.parseLong(tmp[i]));
        }
        for(int i=0;i<m;i++){
            long first = pq.poll();
            long second = pq.poll();
            long res = first + second;
            pq.offer(res);
            pq.offer(res);
        }
        long res = 0;
        while(!pq.isEmpty()){
            res += pq.poll();
        }
        System.out.println(res);
    }
}

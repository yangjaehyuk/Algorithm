import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<num;i++){
            int n = Integer.parseInt(br.readLine());
            pq.add(n);
        }
        int sum = 0;
        while(pq.size() != 1){
            int first = pq.poll();
            int second = pq.poll();
            int tmp = first + second;
            sum += tmp;
            pq.add(tmp);
        }
        
        System.out.println(sum);
    }
    
}

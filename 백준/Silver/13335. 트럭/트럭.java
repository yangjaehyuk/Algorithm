

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] truck_list;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] docs = br.readLine().split(" ");
        int n = Integer.parseInt(docs[0]); // 트럭의 수
        int m = Integer.parseInt(docs[1]); // 다리의 길이
        int w = Integer.parseInt(docs[2]); // 최대 하중
        String[] trucks = br.readLine().split(" ");
        truck_list = new int[n];
        for (int i = 0; i < n; i++) {
            truck_list[i] = (Integer.parseInt(trucks[i]));
        }
        Queue<Integer> q = new LinkedList<>();
        int idx = 0;
        int answer = 0;
        int cur = 0;
        while(true){
            if(idx == n) break;
            if(q.size() == m){
                cur -= q.poll();
            }
            else if(cur + truck_list[idx] > w){
                q.add(0);
                answer++;
            }
            else{
                q.add(truck_list[idx]);
                cur += truck_list[idx];
                idx++;
                answer++;
            }
        }
        answer += m;
        System.out.println(answer);


    }
}

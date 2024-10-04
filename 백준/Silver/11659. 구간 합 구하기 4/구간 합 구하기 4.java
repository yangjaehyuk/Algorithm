import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] docs = br.readLine().split(" ");
        int n = Integer.parseInt(docs[0]);
        int m = Integer.parseInt(docs[1]);
        // m개 이하
        String[] tmp = br.readLine().split(" ");
        int[] list = new int[n + 1];
        int[] pre = new int[n + 1];
        for(int i=1;i<=n;i++){
            list[i] = Integer.parseInt(tmp[i - 1]);
        }
        int tmpv = 0;
        for(int i=1;i<=n;i++){
            tmpv = tmpv + list[i];
            pre[i] = tmpv;
        }
        for(int i=0;i<m;i++){
            String[] temp = br.readLine().split(" ");
            int start = Integer.parseInt(temp[0]);
            int end = Integer.parseInt(temp[1]);
            int sum = pre[end] - pre[start - 1];
            bw.flush();
            bw.write(sum + "\n");
        }
        bw.close();
    }
    
    
}

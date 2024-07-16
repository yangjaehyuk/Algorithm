
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int[] arr;
    static int[] presum;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] docs = br.readLine().split(" ");
        int n = Integer.parseInt(docs[0]);
        int m = Integer.parseInt(docs[1]);
        String[] tmp = br.readLine().split(" ");
        arr = new int[n + 1];
        presum = new int[n + 1];
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(tmp[i - 1]);
        }
        int tmpv = 0;
        for(int i=1; i<=n; i++){
            tmpv = tmpv + arr[i];
            presum[i] = tmpv;
        }
        for(int i=0; i<m; i++){
            String[] res = br.readLine().split(" ");
            int start = Integer.parseInt(res[0]);
            int end = Integer.parseInt(res[1]);
            int sum = presum[end] - presum[start - 1];
            bw.flush();
            bw.write(sum + "\n");
        }
        bw.close();
    }
}

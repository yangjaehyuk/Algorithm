

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int[] arr;
    static long mini = Long.MAX_VALUE;
    static long maxi = Long.MIN_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] docs = br.readLine().split(" ");
        int k = Integer.parseInt(docs[0]);
        int n = Integer.parseInt(docs[1]);
        arr = new int[k];
        for(int i = 0; i < k; i++){
            int line = Integer.parseInt(br.readLine());
            arr[i] = line;
        }
        Arrays.sort(arr);

        mini = 1;
        maxi = arr[k - 1];
        // upperbound
        while(mini <= maxi){
            long cnt = 0;
            long mid = (mini + maxi) / 2;
            for(int j = 0;j < k; j++){
                cnt += arr[j] / mid;
            }
            if(cnt < n){
                maxi = mid - 1;
            }
            else{
                mini = mid + 1;
            }
        }
        System.out.println(maxi);
    }


}

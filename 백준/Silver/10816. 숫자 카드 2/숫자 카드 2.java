
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {
    static int[] arr1;
    static int[] arr2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] docs = br.readLine().split(" ");
        arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(docs[i]);
        }
        int m = Integer.parseInt(br.readLine());
        arr2 = new int[m];
        String[] docs2 = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(docs2[i]);
        }
        Arrays.sort(arr1);
        bw.flush();
        for(int i=0;i<m;i++){
            bw.write(upperbound(arr2[i]) - lowerbound(arr2[i])+" ");
        }
        bw.close();
    }

    public static int lowerbound(int target) {
        int left = 0;
        int right = arr1.length;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (target <= arr1[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int upperbound(int target) {
        int left = 0;
        int right = arr1.length;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (target < arr1[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

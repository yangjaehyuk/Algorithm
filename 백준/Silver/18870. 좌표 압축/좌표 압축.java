import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int[] arr;
    static int[] arrreal;
    static int[] uniqueArr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        arrreal = new int[n];
        String[] docs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(docs[i]);
            arrreal[i] = arr[i];
        }
        Arrays.sort(arr);
        Set<Integer> set = new HashSet<>();
        for (int value : arr) {
            set.add(value);
        }
        uniqueArr = new int[set.size()];
        int index = 0;
        for (int value : set) {
            uniqueArr[index++] = value;
        }
        Arrays.sort(uniqueArr);
        bw.flush();
        for(int i = 0; i < n; i++){
            bw.write(lowerbound(arrreal[i]) + " ");
        }
        bw.close();
    }

    public static int upperbound(int target){
        int left = 0;
        int right = uniqueArr.length;
        int mid;
        while(left < right){
            mid = (left + right) / 2;
            if(target < uniqueArr[mid]){
                right = mid;
            }
            else left = mid + 1;
        }
        return left;
    }
    public static int lowerbound(int target){
        int left = 0;
        int right = uniqueArr.length;
        int mid;
        while(left < right){
            mid = (left + right) / 2;
            if(target <= uniqueArr[mid]){
                right = mid;
            }
            else left = mid + 1;
        }
        return left;
    }
}

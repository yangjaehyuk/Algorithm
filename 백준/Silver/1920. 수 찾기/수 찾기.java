

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main {
    static int[] arr1;
    static int[] arr2;
    static List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr1 = new int[n];
        String[] tmp1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(tmp1[i]);
        }
        int m = Integer.parseInt(br.readLine());
        arr2 = new int[m];
        String[] tmp2 = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(tmp2[i]);
        }
        Arrays.sort(arr1);
        for(int i = 0; i < m; i++){
            boolean check = true;
            int start = 0;
            int end = n - 1;
            int mid;
            int target = arr2[i];
            while(start <= end){
                mid = (start + end) / 2;
                if(target == arr1[mid]){
                    ans.add(1);
                    check = false;
                    break;
                }
                else if(target < arr1[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            if(check){
                ans.add(0);
            }
        }
        for(Integer i : ans){
            System.out.println(i);
        }
    }
}

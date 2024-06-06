import java.util.*;
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        answer = new int[arr1.length][arr2[0].length];
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2[0].length;j++){
                int sum = 0;
                for(int k=0;k<arr2.length;k++){
                    // for(int l=0;l<arr2.length;l++){
                    //     int tmp = arr1[i][j] * arr2[l][k];
                    //     System.out.println(tmp);
                    // }
                    int tmp = arr1[i][k] * arr2[k][j];
                    sum += tmp;
                    // System.out.println(tmp);
                    // System.out.println(i+" "+k+" "+j);
                }
                // System.out.println(sum);
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
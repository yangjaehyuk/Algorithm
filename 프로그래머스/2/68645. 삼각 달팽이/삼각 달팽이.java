import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        int[][] arr = new int[n][n];
        int tmp = 1;
        int cri = 0;
        for(int i=0;i<n;i++){
            // 아래로
            for(int j=cri;j<n;j++){
                if (arr[j][cri] == 0) {
                    arr[j][cri] = tmp++;
                }
            }
            for (int j=cri+1;j<n-cri;j++) {
                if (arr[n-cri-1][j] == 0) {
                    arr[n-cri-1][j] = tmp++;
                }
            }

            // 대각선(-1, -1) 이동
            for (int j=n-cri-2;j>cri;j--) {
                if (arr[j][j-cri]==0) {
                    arr[j][j-cri]=tmp++;
                }
            }
            cri++;
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                // System.out.print(arr[i][j]+" ");
                if(arr[i][j] > 0) list.add(arr[i][j]);
            }
            // System.out.println();
        }
        
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}
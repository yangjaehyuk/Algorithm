import java.util.*;
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<arr1.length;i++){
            List<Integer> tmp = new ArrayList<>();
            for(int j=0;j<arr2[0].length;j++){
                int sum = 0;
                for(int k=0;k<arr1[0].length;k++){
                    sum += arr1[i][k]*arr2[k][j];
                }
                tmp.add(sum);
            }
            list.add(new ArrayList<>(tmp));
        }
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.get(i).size();j++){
                answer[i][j] = list.get(i).get(j);
            }
        }
        return answer;
    }
}
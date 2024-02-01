import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxX=0;
        int maxY=0;
        for(int[] size: sizes){
            Arrays.sort(size);
        }
        for(int i=0;i<sizes.length;i++){
            for(int j=0;j<sizes[0].length;j++){
                if(maxX<sizes[i][0]) maxX=sizes[i][0];
                if(maxY<sizes[i][1]) maxY=sizes[i][1];
            }
        }
        return maxX*maxY;
    }
}
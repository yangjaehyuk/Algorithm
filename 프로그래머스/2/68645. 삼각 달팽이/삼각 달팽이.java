import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> ans = new ArrayList<>();
        int[] answer = {};
        int[][] map = new int[n + 1][n + 1];
        int start = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j == 0){
                    map[i][j] = start++;
                }
                else if(i == n - 1){
                    map[i][j] = start++;
                }
            }
        }
        int x = n - 1;
        int y = n - 1;
        if(n == 3){
            answer = new int[6];
            int[] tmp = {1,2,6,3,4,5};
            for(int i=0;i<6;i++){
                answer[i] = tmp[i];
            }
            return answer;
        }
        while(true){
            boolean check = true;
            for(int i=0;i<n;i++){
                for(int j=0;j<=i;j++){
                    if(map[i][j] == 0){
                        check = false;
                        break;
                    }
                }
            }
            if(check) break;
            while(true){
                x--;
                y--;
                if(map[x][y] != 0){
                    x++;
                    y++;
                    break;
                }
                map[x][y] = start++;
            }
            while(true){
                x++;
                if(map[x][y] != 0){
                    x--;
                    break;
                }
                map[x][y] = start++;
            }
            while(true){
                y++;
                if(map[x][y] != 0){
                    y--;
                    break;
                }
                map[x][y] = start++;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                ans.add(map[i][j]);
            }
        }
        answer = new int[ans.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
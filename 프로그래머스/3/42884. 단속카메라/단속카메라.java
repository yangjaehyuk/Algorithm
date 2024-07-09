import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, new Comparator<>() {
			@Override
			public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
			}			
		});
        if(routes.length == 1) return 1;
        int maxi = -300001;
        for(int i=0;i<routes.length;i++){
            if(maxi == -300001) maxi = routes[i][1];
            else{
                if(maxi < routes[i][0]){
                    maxi = routes[i][1];
                    answer++;
                }
            }
        }
        return answer;
    }
}
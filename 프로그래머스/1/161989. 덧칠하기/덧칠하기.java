class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int start = section[0];
        int tmp = 0;
        for(int sector: section){
            if(sector<tmp) continue;
            answer++;
            tmp=sector+m;
        }
        return answer;
    }
}
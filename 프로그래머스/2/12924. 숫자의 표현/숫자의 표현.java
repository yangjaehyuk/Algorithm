class Solution {
    public int solution(int n) {
        int answer = 1;
        int sum = 0;
        for(int i=1;i<=n/2+1;i++){
            sum = i;
            for(int j=i-1;j>0;j--){
                sum += j;
                if(sum == n){
                    answer++;
                    break;
                }
                else if(sum > n){
                    break;
                }
            }
        }
        return answer;
    }
}
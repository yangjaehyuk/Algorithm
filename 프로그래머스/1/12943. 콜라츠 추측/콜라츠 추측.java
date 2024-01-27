class Solution {
    public int solution(long num) {
        int answer = 0;
        for(int i=0;i<500;i++){
            if(num==1){
                break;
            }
            if(num%2==0){
                num/=2;
                answer++;
            }
            else if(num%2!=0){
                num*=3;
                num++;
                answer++;
            }
        }
        if(answer==500) return -1;
        else return answer;
    }
}
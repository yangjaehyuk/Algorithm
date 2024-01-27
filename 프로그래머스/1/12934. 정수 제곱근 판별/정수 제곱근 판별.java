class Solution {
    public long solution(long n) {
        long answer = 0;
        double tmp = Math.sqrt(n);
        long tmpV = (long)tmp;
        double pow = Math.pow(tmpV,2);
        if((long)pow==n){
            double res = Math.pow(tmpV+1,2);
            answer = (long)res;
        }
        else{
            answer=-1;
        }
        return answer;
    }
}
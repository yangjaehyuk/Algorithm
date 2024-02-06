class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int tmp = 0;
        while(n/a>0){
            tmp = n - n/a*a + n/a*b;
            answer += n/a*b;
            n = tmp;
        }
        return answer;
    }
}
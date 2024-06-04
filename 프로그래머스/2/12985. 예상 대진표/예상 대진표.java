class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        while(a!=b){
            if(a%2!=0){
                a++;
            }
            a/=2;
            
            if(b%2!=0){
                b++;
            }
            b/=2;
            answer++;
            
            
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println("Hello Java");

        return answer;
    }
}
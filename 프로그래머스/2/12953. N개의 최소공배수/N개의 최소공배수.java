class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int res = 0;
        for(int i=1;i<arr.length;i++){
            if(i==1) res = lcm(arr[i-1], arr[i]);
            else{
                res = lcm(res, arr[i]);
                System.out.println(res);
            }
        }
        answer = res;
        return answer;
    }
    
    public static int gcd(int a, int b){
        int r = 0;
        while(b!=0){
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    
    public static int lcm(int a,int b){
        return (a*b) / gcd(a,b);
    }
}
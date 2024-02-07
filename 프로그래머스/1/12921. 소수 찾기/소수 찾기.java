import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        answer=isPrime(n);
        return answer;
    }
    
    public int isPrime(int num){
        int total=0;
        boolean[] eratos = new boolean[num+1];
        eratos[0]=false;
        eratos[1]=false;
        for(int i=2;i<=num;i++){
            eratos[i]=true;
        }
        for(int i=2;i<Math.sqrt(num);i++){
            if(eratos[i]){
                for(int j=i*i;j<=num;j+=i){
                    eratos[j]=false;
                }
            }
        }
        for(int i=2;i<=num;i++){
            if(eratos[i]) total++;
        }
        return total;
    }
}
class Solution {
    public String solution(int n) {
        String answer = "";
        String tmp="수박";
        if(n==1){
            answer="수";
        }
        else{
            if(n%2==0) {
                int cri=n/2;
                for(int i=0;i<cri;i++){
                    answer+=tmp;
                }
            }
            else {
                int cri=n/2;
                for(int i=0;i<cri;i++){
                    answer+=tmp;
                }
                answer+='수';
            }
        }
        
        return answer;
    }
}
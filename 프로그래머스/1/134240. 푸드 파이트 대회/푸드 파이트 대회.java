class Solution {
    public String solution(int[] food) {
        String answer = "";
        for(int i=0;i<food.length;i++){
            if(food[i]%2!=0){
                food[i]--;
                for(int j=0;j<food[i];j++){
                    if(j%2!=0){
                        answer+=i;
                    }
                }
            }
            else{
                for(int j=0;j<food[i];j++){
                    if(j%2!=0){
                        answer+=i;
                    }
                }
            }
        }
        answer+=0;
        char[] arr = answer.toCharArray();
        for(int i=answer.length()-2;i>=0;i--){
            answer+=arr[i];
        }
        return answer;
    }
}
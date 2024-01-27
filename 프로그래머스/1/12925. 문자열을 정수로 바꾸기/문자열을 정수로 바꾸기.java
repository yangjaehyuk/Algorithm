class Solution {
    public int solution(String s) {
        char[] arr = s.toCharArray();
        String answer = "";
        boolean isCheck = false;
        if(arr[0]=='-'){
            for(int i=0;i<s.length();i++){
                answer+=arr[i];
            }
        }
        else{
            if(arr[0]=='+'){
                for(int i=1;i<s.length();i++){
                    answer+=arr[i];
                }
            }
            else{
                for(int i=0;i<s.length();i++){
                    answer+=arr[i];
                }
            }
        }
        int ans = Integer.parseInt(answer);
        return ans;
    }
}
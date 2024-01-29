class Solution {
    public String solution(String s) {
        String answer = "";
        char[] arr = s.toCharArray();
        int len = s.length();
        if(len%2!=0){
            int idx=len/2;
            answer+=arr[idx];
        }
        else{
            int idx=len/2;
            answer+=arr[idx-1];
            answer+=arr[idx];
        }
        return answer;
    }
}
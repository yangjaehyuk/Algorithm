class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        char[] arr = s.toCharArray();
        if((s.length() == 4 || s.length() == 6)){
            for(int i=0;i<s.length();i++){
                if((int)arr[i]<48 || (int)arr[i]>57){
                    answer=false;
                    break;
                }
            }
        }
        else answer=false;
        return answer;
    }
}
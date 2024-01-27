class Solution {
    boolean solution(String s) {
        int checkP=0;
        int checkY=0;
        boolean answer = true;
        char[] arr = s.toCharArray();
        for(int i=0;i<s.length();i++){
            arr[i]=Character.toLowerCase(arr[i]);
        }
        for(int i=0;i<s.length();i++){
            if(arr[i]=='p') checkP++;
            else if(arr[i]=='y') checkY++;
        }
        if(checkP==checkY) answer=true;
        else if(checkP==0 && checkY==0) answer=true;
        else answer=false;
        return answer;
    }
}
class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] arr = s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(arr[i]==' ') answer+=arr[i];
            else{
                int current = (int)arr[i];
                if(current>=65 && current<=90){
                    if(current+n>90){
                        current += n - 26;
                        char cur = (char)current;                    
                        answer+=cur;
                    }
                    else{
                        current += n;
                        char cur=(char)current;
                        answer+=cur;
                    }
                }
                else{
                    if(current+n>122){
                        current += n - 26;
                        char cur = (char)current;
                        answer+=cur;
                    }
                    else{
                        current += n;
                        char cur = (char)current;
                        answer+=cur;
                    }
                    
                }
                
            }
        }
        return answer;
    }
}
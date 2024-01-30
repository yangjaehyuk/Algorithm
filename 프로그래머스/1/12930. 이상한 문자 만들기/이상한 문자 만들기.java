class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ",-1);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length();j++){
                char current = arr[i].charAt(j);
                if(j%2==0){
                    answer+=Character.toUpperCase(current);
                }
                else answer+=Character.toLowerCase(current);
            }
            if(i!=arr.length-1) answer+=' ';
        }
        
        return answer;
    }
}
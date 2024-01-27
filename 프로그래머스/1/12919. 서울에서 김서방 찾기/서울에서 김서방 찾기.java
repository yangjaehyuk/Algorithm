class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int idx=0;
        for(int i=0;i<seoul.length;i++){
            if(seoul[i].equals("Kim")){
                idx=i;
                break;
            }
        }
        answer=String.format("김서방은 %d에 있다",idx);
        return answer;
    }
}
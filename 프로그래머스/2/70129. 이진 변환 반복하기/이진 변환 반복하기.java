class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int check = 0;
        int zeroCnt = 0;
        while(true){
            if(s.equals("1")) break;
            else{
                if(s.contains("0")==true){
                    int len = s.length();
                    s = s.replace("0","");
                    int subLen = s.length();
                    zeroCnt += len - subLen;
                    s = Integer.toBinaryString(subLen);
                    check++;
                }
                else{
                    check++;
                    s = Integer.toBinaryString(s.length());
                }
            }
        }
        answer[0] = check;
        answer[1] = zeroCnt;
        return answer;
    }
}
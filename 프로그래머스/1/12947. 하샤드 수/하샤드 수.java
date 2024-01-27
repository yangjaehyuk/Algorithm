class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String tmpStr = Integer.toString(x);
        char[] arrChar = tmpStr.toCharArray();
        int tmpInt = 0;
        for(int i=0;i<tmpStr.length();i++){
            tmpInt+=Integer.parseInt(Character.toString(arrChar[i]));
        }
        if(x%tmpInt==0) answer=true;
        else answer=false;
        return answer;
    }
}
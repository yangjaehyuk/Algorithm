class Solution {
    public String solution(String new_id) {
        String answer = "";
        String num1 = new_id.toLowerCase();
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<num1.length();i++){
            if(((int)num1.charAt(i)>=97 && (int)num1.charAt(i)<=122) || ((int)num1.charAt(i)>=48 && (int)num1.charAt(i)<=57) || (int)num1.charAt(i)==45 || (int)num1.charAt(i)==95 || (int)num1.charAt(i)==46) builder.append(num1.charAt(i));
        }
        num1 = builder.toString();
        StringBuilder modifiedNum1 = new StringBuilder(num1);
        for (int i = 0; i < modifiedNum1.length() - 1; i++) {
            if (modifiedNum1.charAt(i) == '.' && modifiedNum1.charAt(i+1) == '.') {
                modifiedNum1.setCharAt(i, ' ');
            }
        }
        num1 = modifiedNum1.toString();
        num1 = num1.replaceAll(" ","");
        if((int)num1.charAt(0)==46){
            num1 = num1.substring(1);
        }
        if(num1.length()>0 && (int)num1.charAt(num1.length()-1)==46) num1 = num1.substring(0, num1.length()-1);
        if(num1.length()==0) {
            num1+='a';
            while(true){
                char last = num1.charAt(num1.length()-1);
                if(num1.length()==3) break;
                else num1+=last;
            }
        }
        else if(num1.length()>=16){
            num1 = num1.substring(0,15);
            if(num1.length()>0 && (int)num1.charAt(num1.length()-1)==46) num1 = num1.substring(0, num1.length()-1);
        }
        else if(num1.length()<=2){
            while(true){
                char last = num1.charAt(num1.length()-1);
                if(num1.length()==3) break;
                else num1+=last;
            }
        }
        answer = num1;
        return answer;
    }
}
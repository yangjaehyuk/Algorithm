class Solution {
    public String solution(int a, int b) {
        // 31 29 31 30 31 30 31 31 30 31 30 31
        String answer = "";
        String[] days = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int month=1;
        int day=0;
        int idx=-1;
        while(true){
            day++;
            idx++;
            if(month==a && day==b){
                idx%=7;
                break;
            }
            if(day==31 && (month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12)){
                day=0;
                month++;
            }
            else if(day==30 && (month==4 || month==6 || month==9 || month==11)){
                day=0;
                month++;
            }
            else if(day==29 && month==2){
                day=0;
                month++;
            }
        }
        answer = days[idx];
        return answer;
    }
}
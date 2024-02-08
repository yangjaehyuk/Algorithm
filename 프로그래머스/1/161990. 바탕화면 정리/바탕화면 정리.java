import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        List<Integer> X = new ArrayList<>();
        List<Integer> Y = new ArrayList<>();
        int[] answer = new int[4];
        int cnt=0;
        for(int i=0;i<wallpaper.length;i++){
            char[] arr = wallpaper[i].toCharArray();
            for(int j=0;j<arr.length;j++){
                if(arr[j]=='#'){
                    X.add(i);
                    Y.add(j);
                    cnt++;
                }
            }
        }
        if(cnt==1){
            int start = X.get(0);
            int end = Y.get(0);
            answer[0]=start;
            answer[1]=end;
            answer[2]=start+1;
            answer[3]=end+1;
        }
        else{
            Collections.sort(X);
            Collections.sort(Y);
            int minStart=X.get(0);
            int minEnd=Y.get(0);
            int maxStart=X.get(X.size()-1)+1;
            int maxEnd=Y.get(Y.size()-1)+1;
            answer[0]=minStart;
            answer[1]=minEnd;
            answer[2]=maxStart;
            answer[3]=maxEnd;
        }
        return answer;
    }
}
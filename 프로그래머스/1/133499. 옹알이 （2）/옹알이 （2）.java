class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        String[] nondelete = {"ayaaya", "yeye", "woowoo", "mama"};
        for(int i=0;i<babbling.length;i++){
            for(String word: nondelete){
                babbling[i]=babbling[i].replace(word,"123");
            }
            for(String item: words){
                babbling[i]=babbling[i].replace(item," ");
            }
            babbling[i]=babbling[i].replace(" ","");
            if(babbling[i].length()==0) answer++;
        }
        
        return answer;
    }
}
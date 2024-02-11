import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        HashMap<String, Integer> playerList = new HashMap<>();
        List<String> callingList = new ArrayList<>();
        for(int i=0;i<players.length;i++){
            playerList.put(players[i], i);
        }
        for(int i=0;i<callings.length;i++){
            callingList.add(callings[i]);
        }
        for(String calling: callingList){
            if(playerList.containsKey(calling)){
                int idx = playerList.get(calling);
                String prev = players[idx-1];
                String now = players[idx];
                playerList.put(prev, idx);
                playerList.put(now, idx-1);
                players[idx]=prev;
                players[idx-1]=now;
            }
        }
        return players;
    }
}
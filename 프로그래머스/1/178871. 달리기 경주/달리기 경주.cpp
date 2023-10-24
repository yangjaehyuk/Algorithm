#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>
using namespace std;
map<string, int> arr;

vector<string> solution(vector<string> players, vector<string> callings) {
    for(int i=0;i<players.size();i++){
        string name=players[i];
        int rank=i;
        arr[name]=rank;
    }
    
    for(int i=0;i<callings.size();i++){
        
        //이전 친구는 랭크 더하고
        //호명된 친구는 랭크 빼고
        int idx=arr[callings[i]];
        arr[players[idx-1]]++;
        arr[players[idx]]--;
        swap(players[idx], players[idx-1]);
        
        
    }
    return players;
}
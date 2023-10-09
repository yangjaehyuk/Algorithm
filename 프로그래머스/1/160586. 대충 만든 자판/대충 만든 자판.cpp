#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer;
    for(int i=0;i<targets.size();i++){
        int res=0;
        for(int j=0;j<targets[i].size();j++){
            int tmp=1000;
            for(int k=0;k<keymap.size();k++){
                for(int l=0;l<keymap[k].size();l++){
                    if(targets[i][j]==keymap[k][l]){
                        tmp=min(tmp, l+1);
                        break;
                    }
                }
            }
            res+=tmp;
        }
        if(res>=1000) res=-1;
        answer.push_back(res);
    }
    return answer;
}
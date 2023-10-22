#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<int> solution(vector<string> wallpaper) {
    int minx=21e8;
    int miny=21e8;
    int maxx=0;
    int maxy=0;
    vector<pair<int,int>> tmp;
    vector<int> answer;
    for(int i=0;i<wallpaper.size();i++){
        for(int j=0;j<wallpaper[i].length();j++){
            if(wallpaper[i][j]=='#'){
                tmp.push_back({i,j});
            }
        }
    }
    for(int i=0;i<tmp.size();i++){
        cout<<tmp[i].first<<" "<<tmp[i].second<<endl;
    }
    
    if(tmp.size()==1){
        answer.push_back(tmp[0].first);
        answer.push_back(tmp[0].second);
        answer.push_back(tmp[0].first+1);
        answer.push_back(tmp[0].second+1);
    }
    else{
        for(int i=0;i<tmp.size();i++){
        minx=min(minx,tmp[i].first);
        miny=min(miny,tmp[i].second);
        maxx=max(maxx,tmp[i].first);
        maxy=max(maxy,tmp[i].second);
        }
        answer.push_back(minx);
        answer.push_back(miny);
        answer.push_back(maxx+1);
        answer.push_back(maxy+1);
        
    }
    
    
    return answer;
}
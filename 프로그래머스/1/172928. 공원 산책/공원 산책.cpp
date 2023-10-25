#include <string>
#include <vector>
#include <iostream>
#include <map>
using namespace std;
int tmp=0;
int dx[4]={0,0,1,-1};
int dy[4]={1,-1,0,0};
map<char, int> arrX;
map<char, int> arrY;
// e,w,s,n
vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    vector<pair<int, int>> tmp;
    char container[4]={'E','W','S','N'};
    for(int i=0;i<4;i++){
        arrX[container[i]]=dx[i];
        arrY[container[i]]=dy[i];
    }
    for(int i=0;i<park.size();i++){
        for(int j=0;j<park[i].size();j++){
            if(park[i][j]=='S'){
                tmp.push_back({i,j});
                break;
            }
        }
    }
    
    int x=tmp.front().first;
    int y=tmp.front().second;
    for(int i=0;i<routes.size();i++){
        string direction=routes[i].substr(0, routes[i].find(" "));
        string destination=routes[i].substr(routes[i].find(" ")+1);
        char dir=direction[0];
        int des=stoi(destination);
        int nx=x+arrX[dir]*des;
        int ny=y+arrY[dir]*des;
        int nnx=x;
        int nny=y;
        bool flag=true;
        if(nx<0 || ny<0 || nx>=park.size() || ny>=park[0].size() || park[nx][ny]=='X') continue;
        for(int j=0;j<des;j++){
            nnx+=arrX[dir];
            nny+=arrY[dir];
            if(park[nnx][nny]=='X'){
                flag=false;
                break;
            }
        }
        if(flag==true){
            x=nx;
            y=ny;
            answer.clear();
            answer.push_back(nx);
            answer.push_back(ny);
        }
    }
    if(answer.size()==0){
        answer.push_back(x);
        answer.push_back(y);
    }
    return answer;
}
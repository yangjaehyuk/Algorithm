#include <iostream>
#include <queue>

using namespace std;
queue<pair<int, int>> q;
int visited[1000001]={0,};
int bfs(int start, int end, int up, int down, int floor){
  q.push({start, 0});
  visited[start]=1;
  while(!q.empty()){
    int front=q.front().first;
    int how=q.front().second;
    // cout<<front<<" "<<how<<endl;
    q.pop();
    if(front==end){
      return how;
    }
    if(front-down>0 && visited[front-down]==0){
      q.push({front-down, how+1});
      visited[front-down]=1;
      
    }
    if(front+up<=floor && visited[front+up]==0){
      q.push({front+up, how+1});
      visited[front+up]=1;

    }
    
  }
  return -1;

}
int f, start, goal, up, down;

int main(){
  cin>>f>>start>>goal>>up>>down;
  int ret=bfs(start, goal, up, down, f);
  if(ret==-1) cout<<"use the stairs";
  else cout<<ret;
}
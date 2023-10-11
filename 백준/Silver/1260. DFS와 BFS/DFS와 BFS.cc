#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> arr[1001];
bool visitedD[1001];
bool visitedB[1001];

void dfs(int now){
  cout<<now<<" ";
  visitedD[now]=true;

  for(int i=0;i<arr[now].size();i++){
    int next=arr[now][i];
    if(visitedD[next]==false){
      dfs(next);
    }
  }
};

void bfs(int start){
  queue<int> q;
  q.push(start);
  visitedB[start]=true;

  while(!q.empty()){
    int now=q.front();
    q.pop();
    cout<<now<<" ";

    for(int i=0;i<arr[now].size();i++){
      int next=arr[now][i];
      if(visitedB[next]==false){
        q.push(next);
        visitedB[next]=true;
      }
    }
  }
}
int main(){
  int n,m,v;
  cin>>n>>m>>v;
  for(int i=0;i<m;i++){
    int start,end;
    cin>>start>>end;
    arr[start].push_back(end);
    arr[end].push_back(start);
  }

  for(int i=0;i<=n;i++){
    sort(arr[i].begin(), arr[i].end());
  }

  dfs(v);
  cout<<endl;
  bfs(v);

}
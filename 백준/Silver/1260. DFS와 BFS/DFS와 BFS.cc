#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;
int n,m,v;

vector<int> arr[1001];
bool visitedDfs[1001];
bool visitedBfs[1001];


void dfs(int now){
  visitedDfs[now]=true;
  cout<<now<<" ";
  for(int i=0;i<arr[now].size();i++){
    int next=arr[now][i];
    if(visitedDfs[next]==false){
      dfs(next);
    }
  }
};

void bfs(int start){
  queue<int>q;
  q.push(start);
  visitedBfs[start]=true;

  while(!q.empty()){
    int now=q.front();
    cout<<now<<" ";
    q.pop();

    for(int i=0;i<arr[now].size();i++){
      int next=arr[now][i];
      if(visitedBfs[next]==false){
        q.push(next);
        visitedBfs[next]=true;
      }
    }
  }
}


int main(){
  cin>>n>>m>>v;
  for(int i=0;i<m;i++){
    int start,end;
    cin>>start>>end;
    arr[start].push_back(end);
    arr[end].push_back(start);
  }

  for(int i=1;i<=n;i++){
    sort(arr[i].begin(), arr[i].end());
  }
  
  dfs(v);
  cout<<endl;
  bfs(v);
}
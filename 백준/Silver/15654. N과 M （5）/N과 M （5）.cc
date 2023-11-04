#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int n,m;
vector<int> arr;
int path[10001];
int visited[10001]={0,};
void dfs(int lev, int level, int num){
  if(lev==level){
    for(int i=0;i<m;i++){
      cout<<path[i]<<" ";
    }
    cout<<'\n';
    return;

  }

  for(int i=0;i<n;i++){
    if(visited[i]==1) continue;
    path[lev]=arr[i];
    visited[i]=1;
    dfs(lev+1,level,i+1);
    visited[i]=0;
  }
}
int main(){
  cin.tie(nullptr);
  cout.tie(nullptr);
  cin>>n>>m;
  for(int i=0;i<n;i++){
    int num;
    cin>>num;
    arr.push_back(num);
  }
  sort(arr.begin(), arr.end());
  dfs(0,m,0);
}
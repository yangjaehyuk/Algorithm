#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n,m,num;
vector<int> arr;
int visited[101];
int path[101];
void dfs(int lev, int now){
  if(lev==m){
    for(int i=0;i<m;i++){
      cout<<path[i]<<" ";
    }
    cout<<'\n';
    return;
  }

  for(int i=now;i<n;i++){
    if(visited[i]==1) continue;
    visited[i]=1;
    path[lev]=arr[i];
    dfs(lev+1, i+1);
    visited[i]=0;

  }
}
int main(){
  cin.tie(nullptr);
  cout.tie(nullptr);
  cin>>n>>m;

  for(int i=0;i<n;i++){
    cin>>num;
    arr.push_back(num);
  }

  sort(arr.begin(), arr.end());


  dfs(0,0);
}
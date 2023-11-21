#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int path[101];
int visited[101];
int n,m,num;
vector<int> arr;

void dfs(int lev, int now){
  if(lev==m){
    for(int i=0;i<m;i++){
      cout<<path[i]<<" ";
    }
    cout<<'\n';
    return ;
  }

  for(int i=now;i<n;i++){
    if(visited[i]==1) continue;
    if(i>0 && arr[i-1]==arr[i] && visited[i-1]==0) continue;
    path[lev]=arr[i];
    visited[i]=1;
    dfs(lev+1, i+1);
    visited[i]=0;
  }
}
int main(){
  cin>>n>>m;
  for(int i=0;i<n;i++){
    cin>>num;
    arr.push_back(num);
  }
  sort(arr.begin(), arr.end());

  dfs(0,0);
}
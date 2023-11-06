#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
vector<int> arr;
int n,m;
int path[10];
int visited[10];
void dfs(int lev){
  if(lev==m){
    for(int i=0;i<m;i++){
      cout<<path[i]<<" ";
    }
    cout<<'\n';
    return ;
  }
  for(int i=0;i<n;i++){
    if(visited[i]==1) continue;
    if(arr[i]==arr[i-1] && i>0 && visited[i-1]==0) continue;
    path[lev]=arr[i];
    visited[i]=1;
    dfs(lev+1);
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
  dfs(0);
}
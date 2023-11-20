#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> arr;
int path[101];
int visited[101];
int n,m,num;


void dfs(int lev){
  if(lev==m){
    for(int i=0;i<m;i++){
      cout<<path[i]<<" ";
    }
    cout<<'\n';
    return ;
  }

  for(int i=0;i<n;i++){
    path[lev]=arr[i];
    dfs(lev+1);

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

  dfs(0);

}
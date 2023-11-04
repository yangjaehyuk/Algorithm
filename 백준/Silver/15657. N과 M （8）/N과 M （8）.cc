#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n,m;
vector<int> arr;
int path[9];
int visited[9]={0,};
void dfs(int lev, int num){
  if(lev==m){
    for(int i=0;i<m;i++){
      cout<<path[i]<<" ";
    }
    cout<<'\n';
    return ;
  }
  for(int i=num;i<n;i++){
    path[lev]=arr[i];
    dfs(lev+1,i);
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
  dfs(0,0);

}
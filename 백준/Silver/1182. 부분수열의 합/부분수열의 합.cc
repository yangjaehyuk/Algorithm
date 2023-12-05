#include <iostream>
#include <vector>
using namespace std;

int n,s;
int res=0;
vector<int> stack;
int path[21]={0,};
int visited[21]={0,};
int sum=0;
void dfs(int lev, int level, int cri){
  if(lev==level){
    for(int i=0;i<lev;i++){
      sum+=path[i];
    }
    if(sum==s){
      
      res++;
    }
    sum=0;
    return;
  }

  for(int i=cri;i<n;i++){
    if(visited[i]==1) continue;
    path[lev]=stack[i];
    visited[i]=1;
    dfs(lev+1,level,i+1);
    path[lev]=0;
    visited[i]=0;
  }
}
int main(){
  cin>>n>>s;
  for(int i=0;i<n;i++){
    int num;
    cin>>num;
    stack.push_back(num);
  }
  for(int i=1;i<=n;i++){
    dfs(0,i,0);
  }
  cout<<res;
}
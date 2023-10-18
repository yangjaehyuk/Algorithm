#include <iostream>

using namespace std;

int n,m;
int path[10];
bool visited[10]={0};

void run(int lev, int num){
  if(lev==m){
    for(int i=0;i<lev;i++){
      cout<<path[i]<<" ";
    }
    cout<<'\n';
    return;
  }
  for(int i=num;i<=n;i++){
    if(!visited[i]){
      path[lev]=i;
      visited[i]=true;
      run(lev+1,i+1);
      path[lev]=0;
      visited[i]=false;
    }
  }

}
int main(){
  cin>>n>>m;

  run(0,1);
}
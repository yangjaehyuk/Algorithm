#include <iostream>

using namespace std;

int n,m;
int path[10];

void run(int lev, int level){
  if(lev==level){
    for(int i=0;i<lev;i++){
      cout<<path[i]<<" ";
    }
    cout<<'\n';
    return;
  }

  for(int i=1;i<=n;i++){
    path[lev]=i;
    run(lev+1,level);
  }
}
int main(){
  cin>>n>>m;
  run(0,m);
}
#include <iostream>

using namespace std;

int n,m;
int path[10];

void run(int lev, int num){
  if(lev==m){
    for(int i=0;i<m;i++){
      cout<<path[i]<<" ";
    }
    cout<<"\n";
    return;
  }
  for(int i=num;i<=n;i++){
    path[lev]=i;
    run(lev+1,i);
    
  }
}
int main(){
  cin>>n>>m;
  run(0,1);
}
#include <iostream>
#include <queue>
using namespace std;

queue<pair<long long, long long>> q;

long long bfs(long long start, long long tar){
  while(!q.empty()){
    long long front=q.front().first;
    long long how=q.front().second;
    q.pop();
    if(front==tar){
      return how+1;
    }

    if(front*2<=tar){
      long long nx=front*2;
      q.push({nx, how+1});
    }

    if(front*10+1<=tar){
      long long nnx=front*10+1;
      q.push({nnx, how+1});
    }
    

  }
  return -1;
}
int main(){
  cin.tie(nullptr);
  cout.tie(nullptr);
  long long a,b;
  cin>>a>>b;
  q.push({a,0});
  cout<<bfs(a,b);
}
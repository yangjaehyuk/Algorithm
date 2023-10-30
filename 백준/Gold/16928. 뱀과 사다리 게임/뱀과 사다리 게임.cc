#include <iostream>
#include <queue>
#include <map>
using namespace std;
int visited[110];
int n,m;
queue<pair<int, int>> q;
map<int, int> arr1;
void bfs(int start, int end){
  q.push({start, 0});
  visited[start]=1;
  while(!q.empty()){
    int front=q.front().first;
    int cnt=q.front().second;
    q.pop();
    if(front==end){
      cout<<cnt<<endl;
      break;
    }
    for(int i=1;i<=6;i++){
      int nx=front+i;
      if(nx<=100 && visited[nx]==0){
        if(arr1[nx]>0){
          nx=arr1[nx];
        }
        visited[nx]=1;
        q.push({nx,cnt+1});

      }

    }
  }
}
int main(){
  cin>>n>>m;

  for(int i=0;i<n+m;i++){
    int x,y;
    cin>>x>>y;
    arr1[x]=y;
  }

  for(int i=0;i<111;i++){
    visited[i]=0;
  }

  bfs(1,100);
  // for(int i=0;i<101;i++){
  //   cout<<i<<" "<<arr[i]<<endl;
  // }
}
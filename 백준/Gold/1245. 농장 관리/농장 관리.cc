#include <iostream>
#include <queue>
using namespace std;

queue<pair<int,int>> q;
bool check=true;
int n,m;
int cnt;
int dx[8]={0,0,1,-1,1,-1,1,-1};
int dy[8]={1,-1,0,0,1,-1,-1,1};
int arr[101][71];
int visited[101][71];

void bfs(int i,int j){
    q.push({i,j});
    visited[i][j]=1;

    while(!q.empty()){
      int front=q.front().first;
      int back=q.front().second;

      q.pop();

      for(int k=0;k<8;k++){
        int nx=front+dx[k];
        int ny=back+dy[k];

        if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
        if(arr[front][back]<arr[nx][ny]) check=false;
        if(visited[nx][ny]==1 || arr[nx][ny]!=arr[front][back]) continue;
        q.push({nx,ny});
        visited[nx][ny]=1;
      }
    }
  }

int main(){
  cin>>n>>m;
  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      cin>>arr[i][j];
    }
  }

  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      if(visited[i][j]==0){
        check=true;
        bfs(i,j);
        if(check==true) cnt++;
      }
    }
  }
  cout<<cnt;


}
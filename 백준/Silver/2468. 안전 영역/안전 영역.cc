#include <iostream>
#include <queue>
using namespace std;

int arr[101][101];
int visited[101][101];

int maxi=0;
int n;
queue<pair<int,int>>q;
int dx[4]={0,0,1,-1};
int dy[4]={1,-1,0,0};


void bfs(int height, int tmp[101][101]){
  int cnt=0;
  for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
      visited[i][j]=0;
    }
  }
  for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
      if(arr[i][j]<=height){
        tmp[i][j]=0;
      }
      else tmp[i][j]=1;
    }
  }

  
  for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
      if(tmp[i][j]==1 && visited[i][j]==0){
        cnt++;
        q.push({i,j});
        visited[i][j]=1;
        while(!q.empty()){
          int front=q.front().first;
          int back=q.front().second;
          q.pop();
          for(int k=0;k<4;k++){
            int nx=front+dx[k];
            int ny=back+dy[k];

            if(nx>=0 && ny>=0 && nx<n && ny<n && tmp[nx][ny]==1 && visited[nx][ny]==0){
              q.push({nx,ny});
              visited[nx][ny]=1;
            }
          }
        }
      }
    }
  }
  maxi=max(maxi,cnt);
  return;
}
int main(){
  cin>>n;

  for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
      cin>>arr[i][j];
    }
  }

  for(int i=0;i<=100;i++){
    int tmp[101][101];
    bfs(i, tmp);
  }
  cout<<maxi;
}
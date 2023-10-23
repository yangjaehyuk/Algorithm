#include <iostream>
#include <queue>

using namespace std;

int n,m,cnt,maxi;
int dx[4]={0,0,1,-1};
int dy[4]={1,-1,0,0};
int arr[501][501];
int visited[501][501];
queue<pair<int,int>>q;

void bfs(){
  int check=0;
  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      if(arr[i][j]==1 && visited[i][j]==0){
        cnt++;
        q.push({i,j});
        visited[i][j]=1;

        while(!q.empty()){
          check++;
          int front=q.front().first;
          int back=q.front().second;
          q.pop();

          for(int k=0;k<4;k++){
            int nx=front+dx[k];
            int ny=back+dy[k];

            if(nx>=0 && ny>=0 && nx<n && ny<m && visited[nx][ny]==0 && arr[nx][ny]==1){
              q.push({nx,ny});
              visited[nx][ny]=1;
            }
          }
        }
        maxi=max(maxi,check);
        check=0;
      }
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

  bfs();
  cout<<cnt<<endl;
  cout<<maxi;
}
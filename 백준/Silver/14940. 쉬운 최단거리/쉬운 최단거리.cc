#include <iostream>
#include <queue>

using namespace std;

int arr[1001][1001];
int visited[1001][1001]={0};
int x,y;
int n,m;
int dx[4]={1,-1,0,0};
int dy[4]={0,0,1,-1};

void bfs(int start, int end){
  queue<pair<int,int>> q;
  q.push({start, end});
  visited[start][end]=1;
  arr[start][end]=0;
  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      if(arr[i][j]==1){
        while(!q.empty()){
        int front=q.front().first;
        int back=q.front().second;
        q.pop();

        for(int k=0;k<4;k++){
          int nx=front+dx[k];
          int ny=back+dy[k];

          if(arr[nx][ny]==1 && visited[nx][ny]==0 && nx>=0 && ny>=0 && nx<n && ny<m){
            q.push({nx,ny});
            arr[nx][ny]=arr[front][back]+1;
            visited[nx][ny]=1;
          }
        }
      }
      }
      
    }
  }
}
int main(){
  cin>>n>>m;
  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      cin>>arr[i][j];
      if(arr[i][j]==2){
        x=i;
        y=j;
      }
    }
  }
  bfs(x,y);
  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      if(visited[i][j]==0 && arr[i][j]!=0){
        arr[i][j]=-1;
      }
    }
  }
  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      cout<<arr[i][j]<<" ";
    }
    cout<<endl;
  }

  
}
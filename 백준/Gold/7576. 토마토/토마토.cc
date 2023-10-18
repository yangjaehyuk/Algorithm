#include <iostream>
#include <queue>
using namespace std;

int m,n;

int dx[4]={0,0,1,-1};
int dy[4]={1,-1,0,0};
int arr[1001][1001];
int visited[1001][1001]={0};
int maxi=0;
queue<pair<int,int>>q;
int main(){
  bool flag=false;
  cin>>m>>n;

  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      cin>>arr[i][j];
    }
  }

  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      if(arr[i][j]==0){
        flag=true;
        break;
      }
    }
  }

  if(flag==false){
    cout<<'0';
    return 0;
  }
  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      if(arr[i][j]==1 && visited[i][j]==0){
        arr[i][j]=1;
        q.push({i,j});
        visited[i][j]=1;
      }
    }
  }
  while(!q.empty()){
    int front=q.front().first;
    int back=q.front().second;

    q.pop();
    for(int k=0;k<4;k++){
      int nx=front+dx[k];
      int ny=back+dy[k];

      if(nx>=0 && ny>=0 && nx<n && ny<m && visited[nx][ny]==0 && arr[nx][ny]==0){
        q.push({nx,ny});
        arr[nx][ny]=arr[front][back]+1;
        visited[nx][ny]=1;
        }
      }
  }
  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      if(arr[i][j]==0){
        cout<<"-1";
        return 0;
      }
      else{
        maxi=max(maxi, arr[i][j]);
      }
    }
  }

  cout<<maxi-1;
  return 0;
}
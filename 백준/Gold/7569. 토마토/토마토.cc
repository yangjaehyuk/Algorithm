#include <iostream>
#include <queue>
using namespace std;
struct tri{
  int a;
  int b;
  int c;
};
queue<tri> q;
int maxi=0;
int dx[6]={1,-1,0,0,0,0};
int dy[6]={0,0,1,-1,0,0};
int dh[6]={0,0,0,0,1,-1};
int arr[101][101][101];
int visited[101][101][101];
int m,n,h;
int main(){
  cin.tie(nullptr);
  cout.tie(nullptr);
  cin>>m>>n>>h;
  for(int i=0;i<h;i++){
    for(int j=0;j<n;j++){
      for(int k=0;k<m;k++){
        cin>>arr[i][j][k];
        if(arr[i][j][k]==1){
          q.push({i,j,k});
          visited[i][j][k]=1;
        }
      }
    }
  }
  // for(int i=0;i<h;i++){
  //   for(int j=0;j<n;j++){
  //     for(int k=0;k<m;k++){
  //       cout<<arr[i][j][k]<<" ";
  //     }
  //     cout<<endl;
  //   }
  // }
  while(!q.empty()){
    int first=q.front().a;
    int second=q.front().b;
    int third=q.front().c;

    q.pop();

    for(int l=0;l<6;l++){
      int nz=first+dh[l];
      int nx=second+dx[l];
      int ny=third+dy[l];

      if(nz>=0 && nx>=0 && ny>=0 && visited[nz][nx][ny]==0 && arr[nz][nx][ny]==0 && nz<h && nx<n && ny<m){
        q.push({nz, nx, ny});
        visited[nz][nx][ny]=1;
        arr[nz][nx][ny]=arr[first][second][third]+1;
        }
      }
  }
  for(int i=0;i<h;i++){
    for(int j=0;j<n;j++){
      for(int k=0;k<m;k++){
        if(arr[i][j][k]==0){
          cout<<-1;
          return 0;
        }
        else{
          maxi=max(maxi, arr[i][j][k]);
        }
      }
    }
  }
  cout<<maxi-1;
  // for(int i=0;i<h;i++){
  //   for(int j=0;j<n;j++){
  //     for(int k=0;k<m;k++){
  //       cout<<arr[i][j][k]<<" ";
  //     }
  //     cout<<endl;
  //   }
  // }
}
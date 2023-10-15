#include <iostream>
#include <queue>
using namespace std;

int arr[101][101];
int visited[101][101]={0};
int n,m;
int dx[4]={0,0,1,-1};
int dy[4]={1,-1,0,0};
int dis=0;
int maxi=0;

void bfs(){
  int cnt=1;
  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      if(arr[i][j]==1){
        queue<pair<int,int>> q;
        q.push({i,j});
        visited[i][j]=1;
        arr[i][j]=dis+1;
        while(!q.empty()){
          int start=q.front().first;
          int end=q.front().second;
          q.pop();

          for(int k=0;k<4;k++){
            int nx=start+dx[k];
            int ny=end+dy[k];

            if(nx>=0 && ny>=0 && nx<n && ny<m && arr[nx][ny]==1 && visited[nx][ny]==0){
              
              q.push({nx,ny});
              arr[nx][ny]=arr[start][end]+1;
              visited[nx][ny]=1;
            }
          }
        }
      }
    }
  }
  cout<<arr[n-1][m-1];
}
int main(){
  cin>>n>>m;
  for(int i=0;i<n;i++){
    string str;
    cin>>str;
    for(int j=0;j<m;j++){
      arr[i][j]=str[j]-'0';
    }
  }

  bfs();
}
#include <iostream>
#include <queue>

char arr[601][601];
int visited[601][601];
int dx[4]={0,0,1,-1};
int dy[4]={1,-1,0,0};
int cnt=0;
int friends=0;
using namespace std;

int main(){
  int n,m;
  cin>>n>>m;

  for(int i=0;i<n;i++){
    string str;
    cin>>str;
    for(int j=0;j<m;j++){
      arr[i][j]=str[j];
    }
  }

  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      if(visited[i][j]==0 && arr[i][j]=='I' && cnt==0){
        cnt++;
        queue<pair<int,int>> q;
        q.push({i,j});
        visited[i][j]=1;

        while(!q.empty()){
          int front=q.front().first;
          int back=q.front().second;

          q.pop();

          for(int k=0;k<4;k++){
            int nx=front+dx[k];
            int ny=back+dy[k];

            if(nx>=0 && ny>=0 && nx<n && ny<m && visited[nx][ny]==0 && (arr[nx][ny]=='O' || arr[nx][ny]=='P')){
              if(arr[nx][ny]=='P') friends++;
              q.push({nx,ny});
              visited[nx][ny]=1;
            }
          }
        }
      }
    }
  }
  if(friends==0) cout<<"TT";
  else cout<<friends;

}
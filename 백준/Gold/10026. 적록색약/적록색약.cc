#include <iostream>
#include <queue>
using namespace std;

char arr[101][101];
char copyArr[101][101];
int visitedNot[101][101]={0};
int visitedCol[101][101]={0};
int dx[4]={1,-1,0,0};
int dy[4]={0,0,1,-1};
int n;
int Rcnt, Gcnt, Bcnt=0;
int RGcnt, NewBcnt=0;


void bfs(){
  for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
      if(arr[i][j]=='R' && visitedNot[i][j]==0){
        Rcnt++;
        queue<pair<int,int>> q;
        q.push({i,j});
        visitedNot[i][j]=1;
        while(!q.empty()){
          int front=q.front().first;
          int back=q.front().second;
          q.pop();

          for(int k=0;k<4;k++){
            int nx=front+dx[k];
            int ny=back+dy[k];
            if(nx>=0 && ny>=0 && nx<n && ny<n && arr[nx][ny]=='R' && visitedNot[nx][ny]==0){
              q.push({nx,ny});
              visitedNot[nx][ny]=1;
              }
            }
          }
        }
        else if(arr[i][j]=='G' && visitedNot[i][j]==0){
          Gcnt++;
          queue<pair<int,int>> q;
          q.push({i,j});
          visitedNot[i][j]=1;
          while(!q.empty()){
          int front=q.front().first;
          int back=q.front().second;
          q.pop();

          for(int k=0;k<4;k++){
            int nx=front+dx[k];
            int ny=back+dy[k];
            if(nx>=0 && ny>=0 && nx<n && ny<n && arr[nx][ny]=='G' && visitedNot[nx][ny]==0){
              q.push({nx,ny});
              visitedNot[nx][ny]=1;
              }
            }
          }
        }
        else if(arr[i][j]=='B' && visitedNot[i][j]==0){
          Bcnt++;
          queue<pair<int,int>> q;
          q.push({i,j});
          visitedNot[i][j]=1;
          while(!q.empty()){
          int front=q.front().first;
          int back=q.front().second;
          q.pop();

          for(int k=0;k<4;k++){
            int nx=front+dx[k];
            int ny=back+dy[k];
            if(nx>=0 && ny>=0 && nx<n && ny<n && arr[nx][ny]=='B' && visitedNot[nx][ny]==0){
              q.push({nx,ny});
              visitedNot[nx][ny]=1;
              }
            }
          }
        }
      }
    }
}

void bfs2(){
  for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
      if(copyArr[i][j]=='G' && visitedCol[i][j]==0){
        RGcnt++;
        queue<pair<int, int>>q;
        q.push({i,j});
        visitedCol[i][j]=1;
        while(!q.empty()){
          int front=q.front().first;
          int back=q.front().second;

          q.pop();

          for(int k=0;k<4;k++){
            int nx=front+dx[k];
            int ny=back+dy[k];
            if(nx>=0 && ny>=0 && nx<n && ny<n && visitedCol[nx][ny]==0 && copyArr[nx][ny]=='G'){
              q.push({nx,ny});
              visitedCol[nx][ny]=1;
            }
          }
        }
      }
      else if(copyArr[i][j]=='B' && visitedCol[i][j]==0){
        NewBcnt++;
        queue<pair<int, int>>q;
        q.push({i,j});
        visitedCol[i][j]=1;

        while(!q.empty()){
          int front=q.front().first;
          int back=q.front().second;

          q.pop();

          for(int k=0;k<4;k++){
            int nx=front+dx[k];
            int ny=back+dy[k];

            if(nx>=0 && ny>=0 && nx<n && ny<n && visitedCol[nx][ny]==0 && copyArr[nx][ny]=='B'){
              q.push({nx,ny});
              visitedCol[nx][ny]=1;
            }
          }
        }
      }
    }
  }
}
int main(){
  cin>>n;

  for(int i=0;i<n;i++){
    string str;
    cin>>str;
    for(int j=0;j<n;j++){
      arr[i][j]=str[j];
    }
  }
  for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
      if(arr[i][j]=='R'){
        copyArr[i][j]='G';
      }
      else{
        copyArr[i][j]=arr[i][j];
      }
    }
  }

  bfs();
  int sum1=Rcnt+Gcnt+Bcnt;
  bfs2();
  int sum2=RGcnt+NewBcnt;
  cout<<sum1<<" "<<sum2;
}
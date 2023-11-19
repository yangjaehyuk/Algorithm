#include <iostream>
#include <queue>
using namespace std;

int n,m;
queue<pair<int, int>> q;
int arr[101][101];
int visited[101][101]={0,};
int dx[4]={0,0,1,-1};
int dy[4]={1,-1,0,0};
int main(){
  cin>>n>>m;
  for(int i=0;i<m;i++){
    string str;
    cin>>str;
    for(int j=0;j<n;j++){
      arr[i][j]=str[j]-'\0';
    }
  }
  int wsum=0;
  int bsum=0;
  int wcnt=0;
  int bcnt=0;
  for(int i=0;i<m;i++){
    for(int j=0;j<n;j++){
      if(visited[i][j]==0){
        q.push({i,j});
        visited[i][j]=1;
        if(arr[i][j]==87){
          wcnt=1;
          bcnt=0;
        }
        else{
          bcnt=1;
          wcnt=0;
        }
        while(!q.empty()){
          
          int front=q.front().first;
          int back=q.front().second;
          q.pop();
          for(int k=0;k<4;k++){
            int nx=front+dx[k];
            int ny=back+dy[k];

            if(nx>=0 && ny>=0 && nx<m && ny<n && visited[nx][ny]==0 && arr[nx][ny]==arr[front][back]){
              if(arr[nx][ny]==87){
                q.push({nx,ny});
                visited[nx][ny]=1;
                wcnt++;
              }
              else{
                q.push({nx,ny});
                visited[nx][ny]=1;
                bcnt++;
              }
              
            }
          }
        }
        if(wcnt>0){
          wsum+=wcnt*wcnt;
        }
        else{
          bsum+=bcnt*bcnt;
        }

      }
    

    }
    
  }
  cout<<wsum<<" "<<bsum;
  // 내 병사 87
  // 상대 병사 66

}
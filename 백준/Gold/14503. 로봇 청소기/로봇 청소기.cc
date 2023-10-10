#include <iostream>

using namespace std;

int arr[52][52];
int visited[52][52];


int main(){
  int dx[4]={-1,0,1,0};
  int dy[4]={0,1,0,-1};

  //north east south west
  int cnt=0;

  int n,m;
  cin>>n>>m;

  int x,y,d;
  cin>>x>>y>>d;



  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      cin>>arr[i][j];
      visited[i][j]=0;
    }
  }

  while(true){

    //1
    if(visited[x][y]==0){
      visited[x][y]=1;
      cnt++;
    }

    bool check=false;

    for(int i=0;i<4;i++){
      d=(d+3)%4;
      int nx=x+dx[d];
      int ny=y+dy[d];
      if(arr[nx][ny]==0 && visited[nx][ny]==0){
        x+=dx[d];
        y+=dy[d];
        check=true;
        break;
      }
    }

    if(check==false){
      int backPosition=(d+2)%4;
      int nx=x+dx[backPosition];
      int ny=y+dy[backPosition];
      if(arr[nx][ny]==1) break;
      x+=dx[backPosition];
      y+=dy[backPosition];
    }
  }
  cout<<cnt;

  return 0;

}
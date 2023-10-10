#include <iostream>
using namespace std;


char arr[10][10];

int main(){
  int dx[4]={1,-1,0,0};
  int dy[4]={0,0,1,-1};
  int x,y;
  cin>>x>>y;
  int rx=x;
  int ry=y;
  for(int i=0;i<x;i++){
    for(int j=0;j<y;j++){
      cin>>arr[i][j];
    }
  }

  for(int i=0;i<x;i++){
    for(int j=0;j<y;j++){
      int cnt=0;
      if(arr[i][j]=='X'){
        for(int k=0;k<4;k++){
          int nx=i+dx[k];
          int ny=j+dy[k];
          if(nx<0 || nx>=x || ny<0 || ny>=y) cnt++;
          else if(arr[nx][ny]=='.'){
            cnt++;
          }
        }
        if(cnt>=3){
          arr[i][j]='1';
        }
      }
    }
  }

  for(int i=0;i<x;i++){
    for(int j=0;j<y;j++){
      if(arr[i][j]=='1') arr[i][j]='.';
    }
  }

  int maxRow=0;
  int maxCol=0;
  int minRow=21e8;
  int minCol=21e8;
  for(int i=0;i<x;i++){
    for(int j=0;j<y;j++){
      if(arr[i][j]=='X'){
        if(i>maxCol) maxCol=i;
        if(j>maxRow) maxRow=j;
        if(j<minRow) minRow=j;
        if(i<minCol) minCol=i;
      }
    }
  }

  for(int i=minCol;i<=maxCol;i++){
    for(int j=minRow;j<=maxRow;j++){
      cout<<arr[i][j];
    }
    cout<<endl;
  }
}
#include <iostream>
#include <string>


using namespace std;
char white[8][8]={
  'W','B','W','B','W','B','W','B',
  'B','W','B','W','B','W','B','W',
  'W','B','W','B','W','B','W','B',
  'B','W','B','W','B','W','B','W',
  'W','B','W','B','W','B','W','B',
  'B','W','B','W','B','W','B','W',
  'W','B','W','B','W','B','W','B',
  'B','W','B','W','B','W','B','W',
  
};

char black[8][8]={
  'B','W','B','W','B','W','B','W',
  'W','B','W','B','W','B','W','B',
  'B','W','B','W','B','W','B','W',
  'W','B','W','B','W','B','W','B',
  'B','W','B','W','B','W','B','W',
  'W','B','W','B','W','B','W','B',
  'B','W','B','W','B','W','B','W',
  'W','B','W','B','W','B','W','B',
  
};

char arr[51][51];

int checkWhite(int first, int second){
  int cnt=0;
  for(int i=0;i<8;i++){
    for(int j=0;j<8;j++){
      if(white[i][j]!=arr[first+i][second+j]){
        cnt++;
      }
    }
  }
  return cnt;
}

int checkBlack(int first, int second){
  int cnt=0;
    for(int i=0;i<8;i++){
      for(int j=0;j<8;j++){
        if(black[i][j]!=arr[first+i][second+j]){
          cnt++;
        }
      }
    }
    return cnt;
}

int mini=21e8;
int main(){
  int n,m;
  cin>>n>>m;
  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      cin>>arr[i][j];
    }
  }
  
  for(int i=0;i<=n-8;i++){
    for(int j=0;j<=m-8;j++){
      int tmp=min(checkWhite(i,j), checkBlack(i,j));
      if(mini>tmp) mini=tmp;
    }
  }
  cout<<mini;
}
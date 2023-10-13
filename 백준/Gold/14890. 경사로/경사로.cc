#include <iostream>


using namespace std;
int n,l;
int cnt=0;
int arr1[101][101];
int arr2[101][101];
void check(int arr[][101]){
  for(int i=0;i<n;i++){
    bool flag=true;
    bool visited[101]={0};
    for(int j=0;j<n-1;j++){
      if(abs(arr[i][j]-arr[i][j+1])>1){
        flag=false;
        break;
      }

      if(arr[i][j]==arr[i][j+1]+1){
        // 오른쪽으로
        for(int k=j+2;k<j+1+l;k++){
          if(k>=n || arr[i][k]!=arr[i][j+1]){
            flag=false;
            break;
          }
        }
        if(flag){
          visited[j+l]=true;
        }
        else break;
      }

      if(arr[i][j]+1==arr[i][j+1]){
        // 왼쪽으로
        for(int k=j;k>j-l;k--){
          if(k<0 || arr[i][k]!=arr[i][j] || visited[k]==true){
            flag=false;
            break;
          }
        }
        if(!flag){
          break;
        }
      }
    }
    if(flag==true){
      cnt++;
    }
  }
}

int main(){
  cin>>n>>l;
  for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
      cin>>arr1[i][j];
      arr2[j][i]=arr1[i][j];
    }
  }

  check(arr1);
  check(arr2);
  cout<<cnt;
  

}
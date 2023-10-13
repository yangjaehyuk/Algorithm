#include <iostream>
#include <algorithm>
using namespace std;
int maxi=0;

int arr[1001][1001];
string s[1001];
int main(){
  int n,m;
  cin>>n>>m;
  for(int i=0;i<n;i++){
    cin>>s[i];
    for(int j=0;j<m;j++){
      arr[i][j]=s[i][j]-'0';
    }
  }

  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      if(arr[i][j]==1){
        arr[i][j]=1+min({arr[i-1][j], arr[i-1][j-1], arr[i][j-1]});
        if(maxi<arr[i][j]) maxi=arr[i][j];
      }
    }
  }

  cout<<maxi*maxi;
}
#include <iostream>
#include <algorithm>
using namespace std;


int search(char arr[51][51], int n){
  int maxi=0;
  for(int i=0;i<n;i++){
    int cnt=1;
    for(int j=0;j<n-1;j++){
      if(arr[i][j]==arr[i][j+1]){
        cnt++;
        if(cnt>maxi){
          maxi=cnt;
        }
      }
      else{
        cnt=1;
      }
    }
  }
  for(int i=0;i<n;i++){
    int cnt=1;
    for(int j=0;j<n-1;j++){
      if(arr[j][i]==arr[j+1][i]){
        cnt++;
        if(cnt>maxi){
          maxi=cnt;
        }

      }
      else{
        cnt=1;
      }
    }
  }
  return maxi;
};

char arr[51][51];
int main(){
  int n;
  cin>>n;
  int maxi=0;
  for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
      cin>>arr[i][j];
    }
  }

  for(int i=0;i<n;i++){
    for(int j=0;j<n-1;j++){
      // right
      if(arr[i][j]!=arr[i][j+1]){
        swap(arr[i][j],arr[i][j+1]);
        int tmp=search(arr,n);
        if(tmp>maxi) maxi=tmp;
        swap(arr[i][j],arr[i][j+1]);
      }
      else{
        int tmp=search(arr,n);
        if(tmp>maxi) maxi=tmp;
      }
    }
  }

  for(int i=0;i<n;i++){
    for(int j=0;j<n-1;j++){
      // down
      if(arr[j][i]!=arr[j+1][i]){
        swap(arr[j][i],arr[j+1][i]);
        int tmp=search(arr,n);
        if(tmp>maxi) maxi=tmp;
        swap(arr[j][i],arr[j+1][i]);
      }
      else{
        int tmp=search(arr,n);
        if(tmp>maxi) maxi=tmp;
      }
    }
  }

cout<<maxi;



}
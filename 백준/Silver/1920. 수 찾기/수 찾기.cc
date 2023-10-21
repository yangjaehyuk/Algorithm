#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<int> arr;


int bs(int start, int end, int target){

  while(start<=end){
    int mid=(start+end)/2;

    if(arr[mid]==target) return 1;

    if(arr[mid]>target) end=mid-1;
    else start=mid+1;
  }

  return 0;


}
int main(){
  cin.tie(nullptr);
  cout.tie(nullptr);
  int n;
  cin>>n;

  for(int i=0;i<n;i++){
    int wonso;
    cin>>wonso;
    arr.push_back(wonso);
  }

  sort(arr.begin(), arr.end());

  int m;
  cin>>m;


  
  for(int j=0;j<m;j++){
    int find;
    cin>>find;
    cout<<bs(0,arr.size()-1,find)<<'\n';
  }
}
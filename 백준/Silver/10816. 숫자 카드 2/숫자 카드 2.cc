#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> arr;


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
  for(int i=0;i<m;i++){
    int find;
    cin>>find;
    cout<<(upper_bound(arr.begin(), arr.end(), find)-arr.begin()) - (lower_bound(arr.begin(), arr.end(), find)-arr.begin())<<" ";
  }
}
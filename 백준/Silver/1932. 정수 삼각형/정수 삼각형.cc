#include <iostream>
#include <vector>
using namespace std;

int num;
vector<vector<int>> arr;
int main(){
  int n;
  cin>>n;
  
  for(int i=0;i<n;i++){
    vector<int> tmp;
    for(int j=0;j<=i;j++){
      cin>>num;
      tmp.push_back(num);
    }
    arr.push_back(tmp);
  }

  for(int i=arr.size()-1;i>0;i--){
    for(int j=0;j<arr[i-1].size();j++){
      arr[i-1][j]+=max(arr[i][j], arr[i][j+1]);
    }
  }

  cout<<arr[0][0];

}
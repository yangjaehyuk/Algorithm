#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<pair<int, int>> arr;
vector<pair<int, int>> ans;

bool comp(const pair<int, int>& a, const pair<int, int>& b) {
  if(a.second == b.second) return a.first<b.first;
  return a.second < b.second;
}
int main(){
  int n;
  cin>>n;
  for(int i=0;i<n;i++){
    int a,b;
    cin>>a>>b;
    arr.push_back(make_pair(a,b));
  }

  sort(arr.begin(), arr.end(), comp);

  ans.push_back(make_pair(arr.front().first, arr.front().second));

  for(int i=1;i<arr.size();i++){
    if(ans[ans.size()-1].second<=arr[i].first){
      ans.push_back(make_pair(arr[i].first, arr[i].second));
    }
  }

  // for(int i=0;i<ans.size();i++){
  //   cout<<ans[i].first<<" "<<ans[i].second<<endl;
  // }
  cout<<ans.size();

  
}
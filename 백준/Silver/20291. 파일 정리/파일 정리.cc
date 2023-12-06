#include <iostream>
#include <algorithm>
#include <map>
using namespace std;


int n;
map<string, int> arr;

int main(){
  cin.tie(nullptr);
  cout.tie(nullptr);
  cin>>n;
  for(int i=0;i<n;i++){
    string str;
    cin>>str;
    int idx=str.find('.');
    string newStr=str.substr(idx+1);
    if(arr.find(newStr) != arr.end()){
      arr.insert(make_pair(newStr, arr[newStr]++));
    }
    else{
      arr.insert(make_pair(newStr, 1));
    }
  }

  for(auto x= arr.begin() ; x!=arr.end(); x++){
    cout<<x->first<<" "<<x->second<<endl;
  }



}
#include <iostream>
#include <unordered_map>
#include <string>
using namespace std;


unordered_map<string, string> arr;
int main(){
  cin.tie(NULL);
  ios::sync_with_stdio(false);

  int n,m;
  cin>>n>>m;
  for(int i=0;i<n+1;i++){
    string str;
    getline(cin, str);
    string site=str.substr(0, str.find(" "));
    string password=str.substr(str.find(" ")+1, str.length());
    arr.insert({site, password});
    // cout<<i<<endl;
  }

  for(int k=0;k<m;k++){
    // cout<<"this is k "<<k<<endl;
    string ans;
    cin>>ans;
    cout<<arr[ans]<<'\n';
  }

  
}
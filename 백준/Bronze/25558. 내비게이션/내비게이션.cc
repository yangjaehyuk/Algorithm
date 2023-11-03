#include <iostream>
#include <vector>
#include <climits>
using namespace std;

long long mini=LLONG_MAX;
vector<long long> arr;
long long container[2];
int main(){
  int n;
  cin>>n;
  long long sx, sy, ex, ey;
  cin>>sx>>sy>>ex>>ey;
  
  for(int i=0;i<n;i++){
    long long sum=0;
    long long prevx=sx;
    long long prevy=sy;
    int num;
    cin>>num;
    for(int j=0;j<num;j++){
      long long a,b;
      cin>>a>>b;
      sum+=abs(a-prevx)+abs(b-prevy);
      prevx=a;
      prevy=b;
    }
    sum+=abs(ex-prevx)+abs(ey-prevy);
    // cout<<"this is"<<sum<<endl;
    arr.push_back(sum);

  }

  for(long long i=0;i<arr.size();i++){
    mini=min(mini, arr[i]);
  }

  for(long long i=0;i<arr.size();i++){
    if(mini==arr[i]){
      cout<<i+1;
      return 0;
    }
  }
}
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> arr;
int dat[1001];

int main(){
  int n;
  cin>>n;
  for(int i=0;i<n;i++){
    int num;
    cin>>num;
    dat[i]=num;
  }
  sort(dat,dat+n);
  int sum=0;
  for(int i=0;i<n;i++){
    for(int j=0;j<=i;j++){
      sum+=dat[j];
    }
  }
  cout<<sum;

}
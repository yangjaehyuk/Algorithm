#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<long long> kmContainer;
vector<long long> moneyContainer;

long long sum=0;
long long mini=21e8;

int main(){
  int n;
  cin>>n;
  for(int i=0;i<n-1;i++){
    long long km;
    cin>>km;
    kmContainer.push_back(km);
  }
  for(int i=0;i<n;i++){
    long long money;
    cin>>money;
    moneyContainer.push_back(money);
  }
  for(int i=0;i<kmContainer.size();i++){
    mini=min(mini, moneyContainer[i]);
    if(mini==moneyContainer[i]){
      sum+=kmContainer[i]*moneyContainer[i];
    }
    else{
      sum+=mini*kmContainer[i];
    }
  }
  cout<<sum;
}
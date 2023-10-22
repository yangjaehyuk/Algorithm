#include <string>
#include <vector>
#include <map>
#include <iostream>
using namespace std;
map<char, int> arr;
string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    vector<char> tmp={'R','T','C','F','J','M','A','N'};
    for(int i=0;i<8;i++){
        arr.insert(make_pair(tmp[i],0));
    }
    
     
    
    for(int i=0;i<choices.size();i++){
        if(choices[i]<4){
            arr[survey[i][0]]=arr[survey[i][0]]+(4-choices[i]);
        }
        else if(choices[i]==4){
            continue;
        }
        else{
            arr[survey[i][1]]=arr[survey[i][1]]+(choices[i]-4);
        }
            
    }
    
    for(auto em: arr){
        cout<<em.first<<" "<<em.second<<endl;
    }
    
   
    
    arr['R']>=arr['T'] ? answer+='R' : answer+='T';
    arr['C']>=arr['F'] ? answer+='C' : answer+='F';
    arr['J']>=arr['M'] ? answer+='J' : answer+='M';
    arr['A']>=arr['N'] ? answer+='A' : answer+='N';
    
    
    
    return answer;
}
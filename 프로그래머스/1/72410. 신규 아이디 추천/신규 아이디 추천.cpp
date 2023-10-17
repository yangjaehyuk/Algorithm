#include <string>
#include <vector>
#include <iostream>
using namespace std;
vector<int> container;
string solution(string new_id) {
    for(int j=0;j<new_id.length();j++){
        if(new_id[j]>='A' && new_id[j]<='Z'){
            new_id[j]=static_cast<char>(int(new_id[j])+32);
        }
        else if(static_cast<int>(new_id[j])!=46 && static_cast<int>(new_id[j])!=45 && static_cast<int>(new_id[j])!=95 && isdigit(new_id[j])==0 && isalpha(new_id[j])==0){
            container.push_back(j);
        }
    }
    for(int i=0;i<container.size();i++){
        if(i==0) new_id.erase(container[i],1);
        else{
            new_id.erase(container[i]-i,1);
        }
    }
    
    container.clear();
    for(int i=0;i<new_id.length()-1;i++){
      if(new_id[i]==new_id[i+1] && new_id[i]=='.' && new_id[i+1]=='.'){
            container.push_back(i);
      }
    }
    for(int i=0;i<container.size();i++){
        if(i==0) new_id.erase(container[i],1);
        else new_id.erase(container[i]-i,1);
    }
    container.clear();
    for(int i=0;i<new_id.length();i++){
        if(new_id[0]=='.'){
            new_id.erase(0,1);
        }
        else if(new_id[new_id.length()-1]=='.'){
            new_id.erase(new_id.length()-1,1);
        }
    }
    if(new_id.length()<3){
        if(new_id.length()==0){
            new_id+='a';
            if(new_id.length()<=2){
                while(true){
                    if(new_id.length()==3) break;
                    new_id+=new_id[new_id.length()-1];
                    }
                }
            }
        else if(new_id.length()<=2){
            while(true){
            if(new_id.length()==3) break;
            new_id+=new_id[new_id.length()-1];
        }
    }
        
    }
    else if(new_id.length()>=16){
        new_id=new_id.substr(0,15);
        if(new_id[new_id.length()-1]=='.'){
            new_id.erase(new_id.length()-1,1);
        }
    }
    return new_id;
}
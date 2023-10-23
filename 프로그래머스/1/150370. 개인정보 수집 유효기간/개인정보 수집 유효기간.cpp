#include <string>
#include <vector>
#include <iostream>
#include <map>
using namespace std;
map<string,int>arr;
vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    vector<int> answer;
    for(int i=0;i<terms.size();i++){
        string c=terms[i].substr(0,terms[i].find(" ")); 
        string month=terms[i].substr(terms[i].find(" ")+1, terms[i].length());
        int mon=stoi(month);
        arr[c]=mon;
    }
    for(int i=0;i<privacies.size();i++){
        string date=privacies[i].substr(0, privacies[i].find(" "));
        string category=privacies[i].substr(privacies[i].find(" ")+1, privacies[i].length());
        int year=stoi(date.substr(0,4));
        int month=stoi(date.substr(5,2));
        int day=stoi(date.substr(8));
        int end=arr[category]*28;
        int tYear=stoi(today.substr(0,4));
        int tMonth=stoi(today.substr(5,2));
        int tDay=stoi(today.substr(8));
        for(int j=0;j<end-1;j++){
            day++;
            if(day==29){
                day=1;
                month++;
            }
            if(month==13){
                month=1;
                year++;
            }
            
        }
        
        long long totalToday=28*12*tYear+tMonth*28+tDay;
        long long totalPri=28*12*year+month*28+day;
        
        if(totalToday>totalPri) answer.push_back(i+1);
        
    }
    return answer;
}
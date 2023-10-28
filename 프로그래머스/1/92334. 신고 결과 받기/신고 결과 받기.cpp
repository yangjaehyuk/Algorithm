#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
#include <unordered_map>
using namespace std;

unordered_map<string, int> arr;
unordered_map<string, vector<string>> re;
vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> ans;
    for(int i=0;i<id_list.size();i++){
        arr[id_list[i]]=0;
    }
    sort(report.begin(), report.end());
    report.erase(unique(report.begin(), report.end()),report.end());
    for(int i=0;i<report.size();i++){
        string reporter=report[i].substr(0, report[i].find(" "));
        string criminal=report[i].substr(report[i].find(" ")+1);
        re[criminal].push_back(reporter);
    }
    for(auto it=re.begin();it!=re.end();++it) {
        if(it->second.size()>=k){
            for(const string& reporter: it->second){
                arr[reporter]++;
            }
        }
    }
    
    for(int i=0;i<id_list.size();i++){
        ans.push_back(arr[id_list[i]]);
    }
    
    return ans;
}
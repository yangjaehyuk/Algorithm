#include <string>
#include <vector>

using namespace std;
bool checkSkip(char c, string skip){
    for(int i=0;i<skip.length();i++){
        if(c==skip[i]) return false;
    }
    return true;
}
string solution(string s, string skip, int index) {
    string answer = "";
    for(int i=0;i<s.length();i++){
        char c=s[i];
        for(int j=0;j<index;){
            c++;
            int tmp=int(c);
            if(tmp>122){
                c=static_cast<char>(tmp-123+97);
            }
            if(checkSkip(c, skip)==true){
                j++;
            }
        }
        answer+=c;
        
    }
    return answer;
}
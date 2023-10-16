#include <string>
#include <vector>
using namespace std;

vector<int> stack;

int solution(vector<int> ingredient) {
    // 빵 - 야채 - 고기 - 빵
    // 1 - 빵
    // 2 - 야채
    // 3 - 고기
    int answer = 0;
    
    for(int i=0;i<ingredient.size();i++){
        if(stack.size()<2){
            stack.push_back(ingredient[i]);
        }
        else{
            stack.push_back(ingredient[i]);
            if(stack[stack.size()-4]==1 && stack[stack.size()-3]==2 && stack[stack.size()-2]==3 && stack[stack.size()-1]==1){
                stack.pop_back();
                stack.pop_back();
                stack.pop_back();
                stack.pop_back();
                answer++;
            }
        }
    }
    
    return answer;
}
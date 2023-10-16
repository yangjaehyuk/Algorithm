#include <string>
#include <vector>
#include <iostream>
using namespace std;

string solution(vector<int> numbers, string hand) {
    string answer = "";
    
    // 1,4,7 left
    // 3,6,9 right
    int leftPos=10;
    int rightPos=12;
    for(int i=0;i<numbers.size();i++){
        if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7){
            if(numbers[i]==1){
                leftPos=1;
            }
            else if(numbers[i]==4){
                leftPos=4;
            }
            else{
                leftPos=7;
            }
            answer+='L';
            
        }
        else if(numbers[i]==3 || numbers[i]==6 || numbers[i]==9){
            if(numbers[i]==3){
                rightPos=3;
            }
            else if(numbers[i]==6){
                rightPos=6;
            }
            else{
                rightPos=9;
            }
            answer+='R';
        }
        else{
            // 2580
            if(numbers[i]==2){
                int leftDist=abs((leftPos-numbers[i])/3)+abs((leftPos-numbers[i])%3);
                int rightDist=abs((rightPos-numbers[i])/3)+abs((rightPos-numbers[i])%3);
                int middle=2;
                if (leftDist<rightDist) {
                answer+='L';
                leftPos=middle;
                } 
                else if(leftDist==rightDist) {
                if (hand=="left") {
                    answer+='L';
                    leftPos=middle;
                    }
                else{
                    answer+='R';
                    rightPos=middle;
                    }
                } 
                else {
                answer+='R';
                rightPos=middle;
            }
            }
            else if(numbers[i]==5){
                int leftDist=abs((leftPos-numbers[i])/3)+abs((leftPos-numbers[i])%3);
                int rightDist=abs((rightPos-numbers[i])/3)+abs((rightPos-numbers[i])%3);
                int middle=5;
                if (leftDist<rightDist) {
                answer+='L';
                leftPos=middle;
                } 
                else if(leftDist==rightDist) {
                if (hand=="left") {
                    answer+='L';
                    leftPos=middle;
                    }
                else{
                    answer+='R';
                    rightPos=middle;
                    }
                } 
                else {
                answer+='R';
                rightPos=middle;
            }
            }
            else if(numbers[i]==8){
                int leftDist=abs((leftPos-numbers[i])/3)+abs((leftPos-numbers[i])%3);
                int rightDist=abs((rightPos-numbers[i])/3)+abs((rightPos-numbers[i])%3);
                int middle=8;
                if (leftDist<rightDist) {
                answer+='L';
                leftPos=middle;
                } 
                else if(leftDist==rightDist) {
                if (hand=="left") {
                    answer+='L';
                    leftPos=middle;
                    }
                else{
                    answer+='R';
                    rightPos=middle;
                    }
                } 
                else {
                answer+='R';
                rightPos=middle;
            }
            }
            else if(numbers[i]==0){
                int middle=11;
                int leftDist=abs((leftPos-middle)/3)+abs((leftPos-middle)%3);
                int rightDist=abs((rightPos-middle)/3)+abs((rightPos-middle)%3);
                if (leftDist<rightDist) {
                answer+='L';
                leftPos=middle;
                } 
                else if(leftDist==rightDist) {
                if (hand=="left") {
                    answer+='L';
                    leftPos=middle;
                    }
                else{
                    answer+='R';
                    rightPos=middle;
                    }
                } 
                else {
                answer+='R';
                rightPos=middle;
            }
            }
        }
    }
    return answer;
}
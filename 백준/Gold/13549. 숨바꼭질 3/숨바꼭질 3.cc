#include<iostream>
#include<queue>
using namespace std;
queue<pair <int, int>> q;
bool check[2000000];
int N, K;
void bfs() {
    while (!q.empty()) {
        int x = q.front().first;
        int time = q.front().second;
        check[x] = true;
        q.pop();
        if (x == K) {
            cout << time << "\n";
            break;
        }
        int x3 = 2 * x;
        if (x3 >= 0 && x3 <= 200000 && check[x3] == false) {
            q.push(make_pair(x3, time));
            check[x3] = true;
        }
 
        int x1 = x - 1;
        if (x1 >= 0 && x1 <= 200000 && check[x1] == false) {
            q.push(make_pair(x1, time + 1));
            check[x1] = true;
        }
        int x2 = x + 1;
        if (x2 >= 0 && x2 <= 200000 && check[x2] == false) {
            q.push(make_pair(x2, time + 1));
            check[x2] = true;
        }
    }
}
 
int main(void) {
    cin >> N >> K;
    q.push(make_pair(N, 0));
    bfs();
    return 0;
}
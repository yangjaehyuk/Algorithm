import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int w;
    public static int h;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            char[][] arr;
            boolean[][] visited;
            w = Integer.parseInt(temp[0]); // 너비
            h = Integer.parseInt(temp[1]); // 높이
            arr = new char[h][w];
            visited = new boolean[h][w];
            for (int j = 0; j < h; j++) {
                String docs = br.readLine();
                for (int k = 0; k < w; k++) {
                    arr[j][k] = docs.charAt(k);
                }
            }
            int cnt = bfs(arr, visited);
            System.out.println(cnt == -1 ? "IMPOSSIBLE" : cnt + 1);
        }
    }

    public static class Pair {
        int x;
        int y;
        int cnt;

        Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    public static int bfs(char[][] arr, boolean[][] visited) {
        Queue<Pair> fireQueue = new LinkedList<>();
        Queue<Pair> personQueue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == '@') {
                    personQueue.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                } else if (arr[i][j] == '*') {
                    fireQueue.add(new Pair(i, j, 0));
                }
            }
        }

        while (!personQueue.isEmpty()) {
            int fireSize = fireQueue.size();
            for (int i = 0; i < fireSize; i++) {
                Pair fire = fireQueue.poll();
                for (int m = 0; m < 4; m++) {
                    int nfiresero = fire.x + dx[m];
                    int nfiregaro = fire.y + dy[m];
                    if (nfiresero >= 0 && nfiregaro >= 0 && nfiresero < h && nfiregaro < w && arr[nfiresero][nfiregaro] == '.' && !visited[nfiresero][nfiregaro]) {
                        arr[nfiresero][nfiregaro] = '*';
                        fireQueue.add(new Pair(nfiresero, nfiregaro, 0));
                        visited[nfiresero][nfiregaro] = true;
                    }
                }
            }

            int personSize = personQueue.size();
            for (int i = 0; i < personSize; i++) {
                Pair p = personQueue.poll();
                int sero = p.x;
                int garo = p.y;
                if (sero == 0 || sero == h - 1 || garo == w - 1 || garo == 0) {
                    return p.cnt;
                }
                for (int k = 0; k < 4; k++) {
                    int nsero = sero + dx[k];
                    int ngaro = garo + dy[k];
                    if (nsero >= 0 && ngaro >= 0 && nsero < h && ngaro < w && !visited[nsero][ngaro] && arr[nsero][ngaro] == '.') {
                        visited[nsero][ngaro] = true;
                        personQueue.add(new Pair(nsero, ngaro, p.cnt + 1));
                    }
                }
            }
        }
        return -1;
    }
}

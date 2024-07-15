
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int n;
    static int m;
    static int x;
    static int y;
    static int orders;
    static int[][] arr;
    static int[] dice;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    // 동 서 북 남
    static int[] now = new int[6];
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        n = Integer.parseInt(tmp[0]);
        m = Integer.parseInt(tmp[1]);
        x = Integer.parseInt(tmp[2]);
        y = Integer.parseInt(tmp[3]);
        orders = Integer.parseInt(tmp[4]);
        arr = new int[n][m];
        dice = new int[orders];
        for(int i = 0; i < n; i++){
            String[] docs = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(docs[j]);
            }
        }
        String[] orderList = br.readLine().split(" ");
        for(int i=0;i<orderList.length;i++){
            dice[i] = Integer.parseInt(orderList[i]);
        }
        for(int i=0;i<orders;i++){
                int order = dice[i] - 1;
                int nx = x + dx[order];
                int ny = y + dy[order];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] == 0){
                    // 바닥면 칸에 복사
                    if(order == 0){
                        // 동
                        // 012345
                        // 310542
                        int num1 = now[3];
                        int num2 = now[0];
                        int num3 = now[5];
                        int num4 = now[2];
                        now[0] = num1;
                        now[2] = num2;
                        now[3] = num3;
                        now[5] = num4;
                    }
                    else if(order == 1){
                        // 서
                        // 012345
                        // 215043
                        int num1 = now[2];
                        int num2 = now[5];
                        int num3 = now[0];
                        int num4 = now[3];
                        now[0] = num1;
                        now[2] = num2;
                        now[3] = num3;
                        now[5] = num4;
                    }
                    else if(order == 3){
                        // 남
                        // 012345
                        // 152304
                        int num1 = now[1];
                        int num2 = now[5];
                        int num3 = now[0];
                        int num4 = now[4];
                        now[0] = num1;
                        now[1] = num2;
                        now[4] = num3;
                        now[5] = num4;
                    }
                    else{
                        // 북
                        // 012345
                        // 402351
                        int num1 = now[4];
                        int num2 = now[0];
                        int num3 = now[5];
                        int num4 = now[1];
                        now[0] = num1;
                        now[1] = num2;
                        now[4] = num3;
                        now[5] = num4;
                    }
                    list.add(now[0]);
                    x = nx;
                    y = ny;
                    arr[nx][ny] = now[5];
                }
                else if(nx >= 0 && ny >= 0 && nx < n && ny < m && arr[nx][ny] != 0){
                    // 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사
                    // 칸 0됨
                    if(order == 0){
                        // 동
                        // 012345
                        // 310542
                        int num1 = now[3];
                        int num2 = now[0];
                        int num3 = now[5];
                        int num4 = now[2];
                        now[0] = num1;
                        now[2] = num2;
                        now[3] = num3;
                        now[5] = num4;
                    }
                    else if(order == 1){
                        // 서
                        // 012345
                        // 215043
                        int num1 = now[2];
                        int num2 = now[5];
                        int num3 = now[0];
                        int num4 = now[3];
                        now[0] = num1;
                        now[2] = num2;
                        now[3] = num3;
                        now[5] = num4;
                    }
                    else if(order == 3){
                        // 남
                        // 012345
                        // 152304
                        int num1 = now[1];
                        int num2 = now[5];
                        int num3 = now[0];
                        int num4 = now[4];
                        now[0] = num1;
                        now[1] = num2;
                        now[4] = num3;
                        now[5] = num4;
                    }
                    else{
                        // 북
                        // 012345
                        // 402351
                        int num1 = now[4];
                        int num2 = now[0];
                        int num3 = now[5];
                        int num4 = now[1];
                        now[0] = num1;
                        now[1] = num2;
                        now[4] = num3;
                        now[5] = num4;
                    }
                    list.add(now[0]);
                    x = nx;
                    y = ny;
                    now[5] = arr[nx][ny];
                    arr[nx][ny] = 0;
                }
        }
        for(Integer i : list){
            System.out.println(i);
        }
    }
}

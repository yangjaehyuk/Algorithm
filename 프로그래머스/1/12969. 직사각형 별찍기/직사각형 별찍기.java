import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        char star = '*';
        for(int i=0;i<b;i++){
            String answer="";
            for(int j=0;j<a;j++){
                answer+=star;
            }
            System.out.println(answer);
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		int[][] arr = new int[n][m];
		for(int i=0;i<n;i++) {
			String[] docs = br.readLine().split(" ");
			for(int j=0;j<docs.length;j++) {
				arr[i][j] = Integer.parseInt(docs[j]);
			}
		}
		int maxi = 0;
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<m-1;j++) {
				int temp = arr[i][j]+arr[i+1][j]+arr[i][j+1]+arr[i+1][j+1];
				if(temp>maxi) maxi = temp;
			}
		}
		
		for(int i=0;i<n-3;i++) {
			for(int j=0;j<m;j++) {
				int temp = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+3][j];
				if(temp>maxi) maxi = temp;
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m-3;j++) {
				int temp = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i][j+3];
				if(temp>maxi) maxi = temp;
			}
		}
		
		for(int i=0;i<n-2;i++) {
			for(int j=0;j<m-1;j++) {
				int temp  = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+2][j+1];
				if(temp>maxi) maxi = temp;
			}
		}
		
		for(int i=0;i<n-2;i++) {
			for(int j=0;j<m-1;j++) {
				int temp = arr[i][j] + arr[i][j+1] + arr[i+1][j] + arr[i+2][j];
				if(temp>maxi) maxi = temp;
			}
		}
		
		for(int i=0;i<n-2;i++) {
			for(int j=1;j<m;j++) {
				int temp = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+2][j-1];
				if(temp>maxi) maxi = temp;
			}
		}
		
		for(int i=0;i<n-2;i++) {
			for(int j=1;j<m;j++) {
				int temp = arr[i][j] + arr[i][j-1] + arr[i+1][j] + arr[i+2][j];
				if(temp>maxi) maxi = temp;
			}
		}
		
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<m-2;j++) {
				int temp = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1];
				if(temp>maxi) maxi = temp;
			}
		}
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<m-2;j++) {
				int temp = arr[i][j] + arr[i][j+1] + arr[i-1][j+1] + arr[i][j+2];
				if(temp>maxi) maxi = temp;
			}
		}
		
		for(int i=0;i<n-2;i++) {
			for(int j=1;j<m;j++) {
				int temp = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+1][j-1];
				if(temp>maxi) maxi = temp;
			}
		}
		
		for(int i=0;i<n-2;i++) {
			for(int j=0;j<m-1;j++) {
				int temp = arr[i][j] + arr[i+1][j] + arr[i+2][j] + arr[i+1][j+1];
				if(temp>maxi) maxi = temp;
			}
		}
		
		for(int i=0;i<n-2;i++) {
			for(int j=0;j<m-1;j++) {
				int temp = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+2][j+1];
				if(temp>maxi) maxi = temp;
			}
		}
		
		for(int i=0;i<n-2;i++) {
			for(int j=1;j<m;j++) {
				int temp = arr[i][j] + arr[i+1][j] + arr[i+1][j-1] + arr[i+2][j-1];
				if(temp>maxi) maxi = temp;
			}
		}
		
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<m-2;j++) {
				int temp = arr[i][j] + arr[i][j+1] + arr[i+1][j+1] + arr[i+1][j+2];
				if(temp>maxi) maxi = temp;
			}
		}
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<m-2;j++) {
				int temp = arr[i][j] + arr[i][j+1] + arr[i-1][j+1] + arr[i-1][j+2];
				if(temp>maxi) maxi = temp;
			}
		}
		
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<m-2;j++) {
				int temp = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j];
				if(maxi<temp) maxi = temp;
			}
		}
		
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<m-2;j++) {
				int temp = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+2];
				if(maxi<temp) maxi = temp;
			}
		}
		
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<m-2;j++) {
				int temp = arr[i][j] + arr[i+1][j] + arr[i+1][j+1] + arr[i+1][j+2];
				if(temp>maxi) maxi = temp;
			}
		}
		
		for(int i=1;i<n;i++) {
			for(int j=0;j<m-2;j++) {
				int temp = arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i-1][j+2];
				if(maxi<temp) maxi = temp;
			}
		}
		System.out.println(maxi);
		
	}
}

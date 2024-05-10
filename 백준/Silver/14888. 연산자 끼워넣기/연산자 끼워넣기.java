
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
//	public static int cnt = 0;
	public static int n;
	public static String[] tmp;
	public static String[] docs;
	public static long maxi = -1000000000;
	public static long mini = 1000000000;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		tmp = br.readLine().split(" ");
		String[] doc = br.readLine().split(" ");
		int sum = 0;
		for(int i=0;i<doc.length;i++) {
			sum+=Integer.parseInt(doc[i]);
		}
		docs = new String[sum];
		int idx = 0;
		for(int i=0;i<doc.length;i++) {
			for(int j=0;j<Integer.parseInt(doc[i]);j++) {
				if(i==0) {
					docs[idx++] = "+";
				}
				else if(i==1) {
					docs[idx++] = "-";
				}
				else if(i==2) {
					docs[idx++] = "*";
				}
				else docs[idx++] = "/";
			}
//			System.out.println();
		}
		String[] path = new String[sum];
		boolean[] visited = new boolean[sum];
		dfs(0,sum,path,visited);
//		System.out.println(cnt);
		System.out.println(maxi);
		System.out.println(mini);
	}
	
	public static void dfs(int lev, int level, String[] path, boolean[] visited) {
		int idx1 = 0;
		int idx2 = 0;
		if(lev == level) {
			List<String> list= new ArrayList<String>();
			// 연산 처리
			for(int i=1;i<=lev+tmp.length;i++) {
				if(i%2!=0) {
//					System.out.print(arr[idx2++]);
					list.add(tmp[idx2++]);
				}
				else {
//					System.out.print(path[idx1++]);
					list.add(path[idx1++]);
				}
			}
//			cnt++;
			long res = 0;
			boolean p = false;
			boolean m = false;
			boolean g = false;
			boolean d = false;
			for(int i=0;i<list.size();i++) {
				if(i==0) {
					res += Integer.parseInt(list.get(i));
				}
				else {
					if(Character.isDigit(list.get(i).charAt(0))) {
						int v = Integer.parseInt(list.get(i));
						if(p==true) res+=v;
						else if(m==true) res-=v;
						else if(g==true) res*=v;
						else if(d==true) {
							if(res<0) {
								res*=-1;
								res/=v;
								res*=-1;
							}
							else res/=v;
						}

						p = false;
						m = false;
						g = false;
						d = false;
					}
					else {
						String v = list.get(i);
						if(v.equals("+")) p = true;
						else if(v.equals("-")) m = true;
						else if(v.equals("*")) g = true;
						else if(v.equals("/")) d = true;
					}
				}
			}
//			System.out.println(res);
			
			mini = Math.min((long)(mini), (long)(res));
			maxi = Math.max((long)(maxi), (long)(res));
			
			return;
		}
		String recent = "";
		for(int i=0;i<docs.length;i++) {
			if(!visited[i] && recent != docs[i]) {
				path[lev] = docs[i];
				recent = path[lev];
				visited[i] = true;
				dfs(lev+1, level, path, visited);
				visited[i] = false;
			}
		}
	}

}

import java.io.*;
import java.util.*;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		StringTokenizer st;
		
		st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int dp[][]=new int[N+1][K+1];
		int weight[]=new int[N+1];
		int value[]=new int[N+1];
		
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			weight[i]=Integer.parseInt(st.nextToken());
			value[i]=Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=K;j++) {
				if(weight[i]>j) {
					dp[i][j]=dp[i-1][j];
				}
				else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
				}
				
			}
		}
		System.out.println(dp[N][K]);
		
		
		
	}
}
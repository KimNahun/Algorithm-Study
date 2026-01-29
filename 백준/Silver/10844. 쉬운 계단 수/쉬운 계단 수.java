import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int dp[][] = new int[101][10];
		for(int i=0;i<dp[0].length;i++) {
			dp[1][i] = 1;
		}
		for(int i=2;i<dp.length;i++) {
			for(int j=0;j<dp[0].length;j++) {
				if(j==0) {
					dp[i][j] = dp[i-1][1];
				}
				else if(j==dp[0].length-1) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
				}
				dp[i][j] %= 1000000000;
			}
		}
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		for(int i=1;i<dp[0].length;i++) {
			sum += dp[n][i];
			sum %= 1000000000;
		}
		System.out.println(sum);
		

	}

}

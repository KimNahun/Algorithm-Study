import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int arr[][]= new int[n][n];
		int dp[][] = new int[n][n];
		for(int i=0;i<n;i++) {
			String input[] = br.readLine().split(" ");
			for(int j=0;j<input.length;j++) {
				arr[i][j] = Integer.parseInt(input[j]);
			}
		}
		dp[0][0] = arr[0][0];
		for(int i=1;i<n;i++) {
			for(int j=0;j<=i;j++) {
			//	System.out.println(i + " "+ j);
				if (j==0) {
				//	System.out.println(1);
					dp[i][j] = dp[i-1][j] + arr[i][j];
				} else if (j==i) {
				//	System.out.println(2);
					dp[i][j] = dp[i-1][j-1] + arr[i][j];
				} else {
				//	System.out.println(3);
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + arr[i][j];
				}
				
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			max = Math.max(max, dp[n-1][i]);
		}
		System.out.println(max);
		
		

	}

}

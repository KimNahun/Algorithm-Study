import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int n = Integer.parseInt(br.readLine());
		int dp[] = new int[n+1];
		int arr[] = new int[n+1];
		
		for(int i=1;i<arr.length;i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
		}
		
		dp[1] = arr[1];
		if (n>=2) {
			dp[2] = arr[2] + arr[1];	
		}

		int maxDp = dp[0];
		for(int i=3;i<dp.length;i++) {
			dp[i] = Math.max(dp[i-2], Math.max(dp[i-3]+arr[i-1], maxDp+arr[i-1]))+arr[i];
			maxDp = Math.max(maxDp, dp[i-2]);
		}
		int max = 0;
		for(int i=1;i<dp.length;i++) {
			max = Math.max(dp[i], max);
		}
		System.out.println(max);

	}

}

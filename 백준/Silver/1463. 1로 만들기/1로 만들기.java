import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int dp[] = new int[1000001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 0;
		for(int i=1;i<dp.length;i++) {
			
			if(i+1<dp.length) {
				dp[i+1] = Math.min(dp[i+1], dp[i]+1);
			}
			if(i*2<dp.length) {
				dp[i*2] = Math.min(dp[i*2], dp[i]+1);
			}
			if(i*3<dp.length) {
				dp[i*3] = Math.min(dp[i*3], dp[i]+1);
			}
		}
		int n = Integer.parseInt(br.readLine());
		System.out.print(dp[n]);
		
		

	}

}

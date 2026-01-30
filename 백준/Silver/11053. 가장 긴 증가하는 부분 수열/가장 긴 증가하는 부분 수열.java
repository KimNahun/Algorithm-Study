import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int dp[] = new int[n];
		Arrays.fill(dp, 1);
		int max = 1;
		for(int i=0;i<dp.length;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					max = Math.max(max,dp[i]);
				}
			}
		}
		System.out.println(max);
	}

}

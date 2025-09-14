import java.io.*;
import java.util.*;


public class Main{
	static boolean visited[];
	static int arr[];
	static int result[];
	static int max=0;

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();

		int n=Integer.parseInt(br.readLine());
		int arr[]=new int[n+1];
		int dp[]=new int[n+1];
		
		for(int i=1;i<arr.length;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		dp[1]=arr[1];
		
		if(dp.length>=3) {
			dp[2]=arr[1]+arr[2];
		}
		
		for(int i=3;i<dp.length;i++) {
			dp[i]=Math.max(arr[i-1]+dp[i-3],dp[i-2])+arr[i];
		}
		
		System.out.println(dp[n]);
		

	}
}

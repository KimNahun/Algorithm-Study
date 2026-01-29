import java.io.*;
import java.util.*;

public class Main{
	static int count=0;
	static long dp[];
	public static int parent[];

	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		PriorityQueue <Integer> minheap=new PriorityQueue<>();
		dp=new long[101];
		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		dp[4]=2;
		dp[5]=2;
		for(int i=6;i<dp.length;i++) {
			dp[i]=dp[i-1]+dp[i-5];
		}
		int n=Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int m=Integer.parseInt(br.readLine());
			System.out.println(dp[m]);
		}
	

	}
	
}


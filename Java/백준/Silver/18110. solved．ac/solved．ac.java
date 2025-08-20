import java.util.*;
import java.io.*;


public class Main {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[n];
//		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			arr[i] = Integer.parseInt(br.readLine());
	//		sum += arr[i];
		}
		double k = (double)n * 0.15;
		int f = (int) Math.round(k);
		Arrays.sort(arr);
		double a = 0;
		double cnt = 0;
		for(int i = f;i<arr.length - f;i++) {
			a += arr[i];
			cnt += 1;
		//	System.out.println(arr[i]);
		}
		a /= cnt;
		int result = (int) Math.round(a);
		System.out.println(result);
	
	}
	
}
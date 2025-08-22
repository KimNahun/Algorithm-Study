import java.util.*;
import java.io.*;
class Node implements Comparable<Node> {
	int node;
	int x;
	Node(int node, int x) {
		this.node = node;
		this.x = x;
	}
	
	@Override
	public int compareTo(Node n) {
		if (this.x > n.x) {
			return 1;
		} else {
			return -1;
		}
	}
}

public class Main {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int arr[]= new int[n];
		String input[] = br.readLine().split(" ");
		int right = 0;
		int left = 0;
		for(int i=0;i<arr.length;i++) {
			arr[i] = Integer.parseInt(input[i]);
			right = Math.max(right,arr[i]);
		}
		int m = Integer.parseInt(br.readLine());
		while(left<=right) {
			int mid = (left+right)/2;
			int sum = 0;
			for(int i=0;i<arr.length;i++) {
				if(arr[i]>mid) sum += mid;
				else sum += arr[i];
			}
			if(sum<=m) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		System.out.println(right);
		
	}
	
}
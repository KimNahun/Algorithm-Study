import java.io.*;
import java.util.*;
import java.math.BigInteger;


public class Main{
	static int map[][];
	static boolean visited[][];

	static ArrayList <Integer[]> list=new ArrayList<>();
	static StringBuilder sb=new StringBuilder();
	static HashSet<Integer> set=new HashSet<>();

	static final int INF=100000000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();

		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());
		int dist[][]=new int[n+1][n+1];
		
		for(int i=1;i<dist.length;i++) {
			for(int j=1;j<dist.length;j++) {
				if(i==j)
					dist[i][j] =0;
				else 
					dist[i][j]=INF;
			}
		}
		
		for(int i=0;i<m;i++) {
			String line[]=br.readLine().split(" ");
			int node1=Integer.parseInt(line[0]);
			int node2=Integer.parseInt(line[1]);
			int cost=Integer.parseInt(line[2]);
			dist[node1][node2]=Math.min(dist[node1][node2], cost);
	
			
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				for(int k=1;k<=n;k++) {
					dist[j][k]=Math.min(dist[j][k], dist[j][i]+dist[i][k]);
				}
			}
		}
		
		for(int i=1;i<dist.length;i++) {
			for(int j=1;j<dist.length;j++) {
				if(dist[i][j]==INF) System.out.print(0+" ");
				else System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
}
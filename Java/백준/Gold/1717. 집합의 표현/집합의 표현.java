import java.util.*;
import java.io.*;
public class Main {
	public static int map[][];
//	public static boolean visited[][];
	public static int X[]= {0,0,1,-1};
	public static int Y[]= {-1,1,0,0};
	public static ArrayList<Integer>[] graph;
	public static boolean visited[];
	public static int parent[];
	
	public static HashSet <String> set=new HashSet<>(); 
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		
		String temp[]=br.readLine().split(" ");
		int a=Integer.parseInt(temp[0]);
		int b=Integer.parseInt(temp[1]);
		parent=new int[a+1];
		for(int i=1;i<parent.length;i++) {
			parent[i]=i;
		}
		for(int i=0;i<b;i++) {
			String line[]=br.readLine().split(" ");
			int require=Integer.parseInt(line[0]);
			int node1=Integer.parseInt(line[1]);
			int node2=Integer.parseInt(line[2]);
			if(require==0) {
				union(node1,node2);
			}
			else if(require==1){
				if(find(node1)==find(node2))
					bw.write("YES\n");
				else
					bw.write("NO\n");
			}
			
		}
		
		bw.flush();
		bw.close();
		
	}
	public static void union(int x,int y) {
		x=find(x);
		y=find(y);
		if(x>y)
			parent[x]=y;
		else
			parent[y]=x;
	}
	public static int find(int x) {
		if(parent[x]==x)
			return x;
		
		return parent[x]=find(parent[x]);
	}
}

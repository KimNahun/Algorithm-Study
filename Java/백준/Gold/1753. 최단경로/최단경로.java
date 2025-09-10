import java.util.*;
import java.io.*;
class Node implements Comparable<Node>{
	int node;
	int cost;
	public Node(int node,int cost){
		this.node=node;
		this.cost=cost;
	}
	@Override
	public int compareTo(Node o) {
		if(this.cost>=o.cost)
			return 1;
		return -1;
	}
}
public class Main{
	public static ArrayList<Node> graph[];
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		String temp[]=br.readLine().split(" ");
		int n=Integer.parseInt(temp[0]);
		int m=Integer.parseInt(temp[1]);
		int start=Integer.parseInt(br.readLine());
		graph=new ArrayList[n+1];
		
		for(int i=1;i<=n;i++) {
			graph[i]=new ArrayList<>();
		}
		
		for(int i=0;i<m;i++) {
			String line[]=br.readLine().split(" ");
			int a=Integer.parseInt(line[0]);
			int b=Integer.parseInt(line[1]);
			int c=Integer.parseInt(line[2]);
			graph[a].add(new Node(b,c));
		}
		
		dijkstra(start,n+1);
		
		
	}
	public static void dijkstra(int node,int n){
		StringBuilder sb=new StringBuilder();
		int dist[]=new int[n];
		boolean check[]=new boolean[n];
		PriorityQueue<Node> min=new PriorityQueue<>();
		Arrays.fill(dist, Integer.MAX_VALUE);
		min.add(new Node(node,0));
		dist[node]=0;
		while(!min.isEmpty()) {
			int nowvertex=min.poll().node;
			if(check[nowvertex]==true)
				continue;
			
			check[nowvertex]=true;
			for(Node next:graph[nowvertex]) {
				if(dist[next.node]>dist[nowvertex]+next.cost) {
					dist[next.node]=dist[nowvertex]+next.cost;
					min.add(new Node(next.node,dist[next.node]));
				}
			}
		}
		boolean one=false;
		for(int i:dist) {
			if(one==false) {
				one=true;
				continue;
			}
			if(i==Integer.MAX_VALUE) sb.append("INF\n");
			else sb.append(i+"\n");
		}
		System.out.println(sb);
		
		
	}
}


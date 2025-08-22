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
		
		String input[] = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int map[][]= new int[n][m];
		int newMap[][] = new int[n][m];
		for(int i=0;i<n;i++) {
			input = br.readLine().split("");
			for(int j=0;j<map[0].length;j++) {				
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		for(int i=0;i<n;i++) {
			input = br.readLine().split("");
			for(int j=0;j<map[0].length;j++) {				
				newMap[i][j] = Integer.parseInt(input[j]);
			}
		}
		int count = 0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				
				if(map[i][j] != newMap[i][j]) {
					if(i+2>=map.length) { continue; }
					if(j+2>=map[0].length) { continue; }
					count ++;
					for(int k=i;k<i+3;k++) {
						for(int l=j;l<j+3;l++) {
							if (map[k][l] == 0) {
								map[k][l] = 1;
							} else {
								map[k][l] = 0;
							}
						}
					}
				//	printMap(map);
				}
			}
		}
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				if(map[i][j] != newMap[i][j]) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		System.out.println(count);
	}
	public static void printMap(int map[][]) {
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
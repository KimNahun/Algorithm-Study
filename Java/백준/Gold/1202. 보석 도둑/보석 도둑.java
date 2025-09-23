import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Arr {
	int weight;
	int price;
	Arr(int weight,int price){
		this.weight=weight;
		this.price=price;
	}

}
public class Main{
	static final int INF=100000000;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		Queue<Integer> queue=new LinkedList<>();


		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		Arr arr[]=new Arr[N];
		Integer bag[]=new Integer[K];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int weight=Integer.parseInt(st.nextToken());
			int price=Integer.parseInt(st.nextToken());
			arr[i]=new Arr(weight,price);
		}
		for(int i=0;i<K;i++) {
			bag[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr, new Comparator<>() {
			@Override
			public int compare(Arr j1, Arr j2) {
				if(j1.weight>j2.weight)
					return 1;
				else if(j1.weight==j2.weight) {
					if(j1.price<j2.price)
						return 1;
					else if(j1.price==j2.price)
						return 0;
				}
				return -1;
			}
		});
		Arrays.sort(bag);


		long sum=0;
		PriorityQueue<Arr> pq=new PriorityQueue<>((o1,o2)->o2.price-o1.price);

		int index=0;
		for(int i=0;i<bag.length;i++) {
			int thisBagWeight=bag[i];

			while(index<arr.length&&arr[index].weight<=thisBagWeight) {
				pq.add(arr[index]);
				index++;
			}


			if(!pq.isEmpty())
				sum+=pq.poll().price;

		}
		System.out.println(sum);

	}
}


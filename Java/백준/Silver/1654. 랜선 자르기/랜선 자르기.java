import java.util.*;
import java.io.*;

public class Main{
	public static int arr[];
	public static int count=0;

	public static void main(String[] args)throws IOException {

		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		long arr[]=new long[a];
		long max=0;
		
		
		for(int i=0;i<a;i++) {
			arr[i]=sc.nextInt();
			if(arr[i]>max)
				max=arr[i];
		}
		long min=1;
		long mid=0;
		
		
		
		while(min<=max) {
			mid=(max+min)/2;
			long count=0;
			for(int i=0;i<arr.length;i++) {
				count+=(arr[i]/mid);
			}
			if(count<b) {
				max=mid-1;
			}
			else {
				min=mid+1;
			}
		}
		System.out.println(min-1);
		
		
	}

}
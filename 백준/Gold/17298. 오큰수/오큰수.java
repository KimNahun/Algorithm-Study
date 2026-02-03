import java.util.*;
import java.io.*;
public class Main {
	static ArrayList<Integer[]> baad = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int arr[] =Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Stack<Integer> stack = new Stack<>();
		int result[] = new int[n];

		for(int i=0;i<arr.length;i++) {

			while(!stack.isEmpty()) {
				if(arr[stack.peek()]<arr[i]) {
					result[stack.pop()] = arr[i];
				} else {
					break;
				}
			}


			stack.add(i);

		}
		while(!stack.isEmpty()) {
			result[stack.pop()] = -1;
		}

		for(int i=0;i<result.length;i++) {
			sb.append(result[i]).append(' ');
		}

		System.out.print(sb.toString());

	}

}

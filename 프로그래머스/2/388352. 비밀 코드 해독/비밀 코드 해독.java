import java.util.*;
class Solution { 
    static int arr[];
    static boolean visited[];
    static int qq[][];
    static int anss[];
    static ArrayList<int[]> list = new ArrayList<>();
    static int answer = 0;
    public int solution(int n, int[][] q, int[] ans) {
        arr = new int[5];
        visited = new boolean[n];
        qq = q;
        anss = ans;
        dfs(0,0);
        
        
       
        return answer;
    }
    public static void check(int password[]) {
      
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<password.length;i++) {
            set.add(password[i]);
        }
        int count[] = new int[qq.length];
        for(int i=0;i<qq.length;i++) {
            for(int j=0;j<qq[0].length;j++) {  
               if(set.contains(qq[i][j])) {
                   count[i] ++;
               }
            }
        }
        int cnt = 0;
        for(int j=0;j<count.length;j++) {
            if(count[j] == anss[j]) {
                    cnt++;
            }
        }
        if(cnt==anss.length) {
            answer++;
        }
    }
    public static void dfs(int depth, int start) {
        
        if (depth == arr.length) {
            check(arr);
            return;
        }
        for(int i=start;i<visited.length;i++) {
            if(!visited[depth]) {
                visited[depth] = true;
                arr[depth] = i+1;
                dfs(depth+1, i+1);
                visited[depth] = false;
            }
        }
    }
    public static void printMap() {
       // System.out.print
        for(int i=0;i<list.size();i++) {
            for(int j=0;j<list.get(i).length;j++) {
                System.out.print(list.get(i)[j] +" ");
            }
            System.out.println();
        }
    }
}
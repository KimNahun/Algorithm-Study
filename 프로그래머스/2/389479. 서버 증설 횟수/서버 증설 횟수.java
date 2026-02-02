import java.util.*;
class Solution {
    static Queue<Integer> queue = new LinkedList<>();
    public int solution(int[] players, int m, int k) {
        int result = 0;
        for(int i=0;i<players.length;i++) {
            reduceServer();
            int nowServer = queue.size()+1;
            if(nowServer*m>players[i]) {
                
            } else {
                int cnt = players[i] / m - nowServer + 1;
              //  System.out.println(cnt);
                for(int j=0;j<cnt;j++) {
                    queue.add(k);
                    result++;
                }
            }
         //    System.out.println(i+" "+(queue.size()+1) + " " + result);
        }
        return result;
    }
    public static void reduceServer() {
        int count = queue.size();
        for(int i=0;i<count;i++) {
            int poll = queue.poll();
            poll--;
            if(poll==0) continue;
            else {
                queue.add(poll);
            }
        }
    }
}
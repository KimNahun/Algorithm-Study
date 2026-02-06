import java.util.*;
class Point {
    int number;
    int nowY;
    int nowX;
    int[] remain;
    Point(int number, int nowY, int nowX, int[] remain) {
        this.number = number;
        this.nowY=nowY;
        this.nowX=nowX;
        this.remain=remain;
    }
}
class Solution {
    public int solution(int[][] points, int[][] routes) {
        HashMap<Integer, Integer[]> map = new HashMap<>();
        Queue<Point> queue = new LinkedList<>();
        int maxY = 0;
        int maxX = 0;
        // 해시에 좌표 넣음
        for(int i=0;i<points.length;i++) {
            Integer[] n = {points[i][0]-1, points[i][1]-1};
            maxY = Math.max(maxY, points[i][0]-1);
            maxX = Math.max(maxX, points[i][1]-1);
            map.put(i+1, n);
        }
        int visitedCount[][] = new int[101][101];
        System.out.println(maxY+ " "+maxX);
        // 큐에 넣음.
        for(int i=0;i<routes.length;i++) {
            int k = routes[i][0];
            Integer[] l = map.get(k);
            queue.add(new Point(i+1, l[0], l[1], routes[i]));
        //    System.out.println(i+1 +" " + l[0]+" " + l[1]+" " + routes[i]);
        }
        
        int cycle = routes.length;
        HashSet<Integer> visitedNode = new HashSet<>();
        int answer = 0;
        if(answer==0) {
          //  return 0;
        }
        while(!queue.isEmpty()) {
            Point poll = queue.poll();
            int number = poll.number;
            int nowY = poll.nowY;
            int nowX = poll.nowX;
            int remain[] = poll.remain;
        //    System.out.println("K"+number+" "+nowY+" "+nowX+" "+map.get(remain[0])[0]+" "+map.get(remain[0])[1]);
            if(visitedNode.contains(number)) {
           //     printMap(visitedCount);
                visitedNode = new HashSet<>();
                visitedCount = new int[visitedCount.length][visitedCount[0].length];
            }
            visitedNode.add(number);
            
                
            visitedCount[nowY][nowX]++;
            if(visitedCount[nowY][nowX]==2) {
                answer++;
            }
            
            if(nowY == map.get(remain[0])[0] && nowX == map.get(remain[0])[1]) {
                int copy[] = new int[remain.length-1];
                for(int i=0;i<copy.length;i++) {
                    copy[i] = remain[i+1];
                }
                remain = copy;
            } 

            if(remain.length!=0) {
                int next[] = calcNextPlace(nowY, nowX, map.get(remain[0])[0], map.get(remain[0])[1]);
         //      System.out.println(number+" "+ nowY+" "+ nowX+" "+ next[0]+" "+next[1]);
                queue.add(new Point(number, next[0], next[1], remain));
            } 
        }
         // int number;
         // int nowY;
         // int nowX;
         // int[] remain;

        return answer;
    }
    public static void printMap(int [][] arr) {
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[0].length;j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
           System.out.println();
    }
    public static int[] calcNextPlace(int nowY, int nowX, int nextY, int nextX) {

        if(nowY!=nextY) {
            if(nowY>nextY) nowY --;
            else nowY ++;
        } else {
            if(nowX>nextX) nowX --;
            else nowX++;
        }
        int result[] = {nowY, nowX};
        return result;
    }
}
// [[3, 2], [6, 4], [4, 7], [1, 4]]
// [4, 2], [1, 3], [4, 2], [4, 3]]	

// [[2, 2], [2, 3], [2, 7], [6, 6], [5, 2]]	
// [[2, 3, 4, 5], [1, 3, 4, 5]]
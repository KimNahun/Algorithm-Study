import java.util.*;
class Solution {
    static ArrayList<Integer[]> sideList = new ArrayList<Integer[]>();
    static boolean visited[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static char map[][];
    public int solution(String[] storage, String[] requests) {
        visited = new boolean[storage.length][storage[0].length()];
        map = new char[storage.length][storage[0].length()];
        insertSidePoints(storage);
        for(int i=0;i<map.length;i++) {
            for(int j=0;j<map[0].length;j++) {
                map[i][j] = storage[i].charAt(j);
            }
        }
        
        for(int i=0;i<requests.length;i++) {
            char input = requests[i].charAt(0);
            if(requests[i].length() == 2) {
                crain(input);
            } else {
                chooseSide(input);
                car(input);
            }
            
            for(int j=0;j<visited.length;j++) {
                Arrays.fill(visited[j], false);
            }
     //       printMap();
        }
        int cnt = 0;
        for(int i=0;i<map.length;i++) {
            for(int j=0;j<map[0].length;j++) {
                if(map[i][j] != '0') { cnt++; }
            }
        }
        return cnt;
    }
    public static void printMap() {
        for(int i=0;i<map.length;i++) {
            for(int j=0;j<map[0].length;j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
         System.out.println();
    }
    public static void chooseSide(char ch) {
        for(int i=0;i<sideList.size();i++) {
            bfs(sideList.get(i)[0], sideList.get(i)[1], ch);
            
        }
    }
    public static void car(char ch) {
        for(int i=0;i<map.length;i++) {
            for(int j=0;j<map[0].length;j++) {
                if(visited[i][j]&&map[i][j] == ch) {
                    map[i][j] = '0';
                }
            }
        }
    }
    public static void crain(char ch) {
        for(int i=0;i<map.length;i++) {
            for(int j=0;j<map[0].length;j++) {
                if(map[i][j] == ch) {
                    map[i][j] = '0';
                }
            }
        }
    }
    public static void fillMap(String[] arr) {
        
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[0].length();j++) {
                map[i][j] = arr[i].charAt(j);
            }
        }
        
    }
    
    public static void bfs(int y, int x, char ch) {
        visited[y][x] = true;
     //   System.out.println(y+" "+x);
        for(int i=0;i<dx.length;i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];
            if(nextY<0||nextX<0||nextY>=visited.length||nextX>=visited[0].length) {
                continue;
            }
            if(visited[nextY][nextX]) {
                continue;
            }
            
            if(map[nextY][nextX] == '0' && map[y][x] == '0' || (map[nextY][nextX] == ch && map[y][x] == '0')) {
         //       System.out.println(y+" "+x+" "+nextY+ " "+nextX);
         //       System.out.println(map[y][x]+" "+map[nextY][nextX]);
                bfs(nextY,nextX, ch);
            }
        }
    }
    
    public static void insertSidePoints(String[] arr) {
        
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length();j++) {
                if(i==0||j==0||i==arr.length-1||j==arr[i].length()-1) {
                    sideList.add(new Integer[]{i,j});
              //      System.out.println(i+" "+j);
                }
            }
        }
        
    }
}
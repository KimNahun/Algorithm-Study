import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
       
        int dp[][] = new int[info.length+1][m+1];
        int[][] numbers = new int[info.length+1][2];
        int sum = 0;
        for(int i=1;i<numbers.length;i++){
            numbers[i][0] = info[i-1][0];
            numbers[i][1] = info[i-1][1];
            sum += info[i-1][0];
        }
        for(int i=0;i<dp.length;i++) {
            Arrays.fill(dp[i], sum);
        }
    
        for(int i=1;i<dp.length;i++) {
            for(int j=1;j<dp[0].length-1;j++) {
                dp[i][j] = dp[i-1][j];
                if(j-numbers[i][1] >= 0) {
                     dp[i][j] = Math.min(dp[i][j], dp[i-1][j-numbers[i][1]] - numbers[i][0]);
                } 
            }
        }
       
        int answer = 0;
        return dp[info.length][m-1] < n ? dp[info.length][m-1] : -1;
    }
}
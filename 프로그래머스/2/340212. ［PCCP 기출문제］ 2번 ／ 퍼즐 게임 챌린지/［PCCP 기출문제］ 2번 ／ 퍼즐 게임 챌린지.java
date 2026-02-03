class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        long start = 0;
        long end = Long.MAX_VALUE;
        int cnt = 0;
        long mid = 0;
        long min = Long.MAX_VALUE;
        // if(diffs.length==1) {
        //     return times[0];
        // }
        while(start<=end) {
            mid = (start+end)/2;
            long solved = solve(mid, diffs, times);
            if(solved>limit) {
                start=mid+1;
            } else {
                min = Math.min(min, mid);
                end = mid-1;
            }
        }
        return min==0? 1: (int)min;
    }
    public static long solve(long level, int [] diff, int [] time) {
        long sum = time[0];
        for(int i=1;i<diff.length;i++) {
            if(level>=diff[i]) {
                sum+=time[i];
            } else {
                sum+= ((time[i] + time[i-1])*(diff[i]-level)+time[i]);
            }
        }
        return sum;
    } 
}
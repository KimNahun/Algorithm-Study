import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, new Comparator<>(){
            @Override
            public int compare(int target1[], int target2[]) {
                if (target1[1] != target2[1]) {
                    return Integer.compare(target1[1], target2[1]); 
                } else {
                    return Integer.compare(target1[0], target2[0]); 
                }
            }
        });
        int max = 0;
        int count = 0;
        for(int i=0;i<targets.length;i++) {
       //     System.out.println(targets[i][0] +" "+targets[i][1]+" ");
            if(targets[i][0] >= max) {
                max = targets[i][1];
                count++;
            }
        }
        int answer = 0;
        return count;
    }
}
//[1,4]
//[3,7]
//[4,5]
//[4,8]
//[5,12]
//[10,14]
//[11,13]
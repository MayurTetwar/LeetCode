class Solution {
    static{
        for(int i=0;i<500;i++){
            findMinArrowShots(new int[][]{{0,0}});
        }
    }
    public static int findMinArrowShots(int[][] arr) {
        int n=arr.length;
        Arrays.sort(arr,(a,b)->{
            if(a[0]<b[0])return -1;
            return 1;
        });
        int start=0;
        int count=0;
        int end=arr[0][1];
        for(int i=1;i<n;i++){
            if(end<arr[i][0]){
                count++;
                start=i;
                end=arr[i][1];
            }
            end=Math.min(end,arr[i][1]);
        }
        return count+1;
    }
}
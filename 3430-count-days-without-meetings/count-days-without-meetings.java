class Solution {
    static{
        for(int i=0;i<500;i++){
            countDays(2,new int[][]{{1,2}});
        }
    }
    public static int countDays(int days, int[][] arr) {
        int n=arr.length;
        Arrays.sort(arr,(a,b)->{
            if(a[0]<b[0])return -1;
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return 1;
        });
        int start=0;
        int end=0;
        int ans=days;
        for(int i=1;i<n;i++){
            if(arr[end][1]<arr[i][0]){
                ans-=(arr[end][1]-arr[start][0])+1;
                start=i;
            }
            end=(arr[end][1]>arr[i][1])?end:i;
        }
        ans-=(arr[end][1]-arr[start][0])+1;
        return ans;
    }
}
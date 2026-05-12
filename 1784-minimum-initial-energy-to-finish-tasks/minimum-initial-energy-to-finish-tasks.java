class Solution {
    public int minimumEffort(int[][] arr) {
        Arrays.sort(arr,(a,b)->a[1]-a[0]-(b[1]-b[0]));
        int ans=0;
        for(int[] a:arr){
           ans=Math.max(ans+a[0],a[1]);
        }
        return ans;
    }
}
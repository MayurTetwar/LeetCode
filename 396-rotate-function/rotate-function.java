class Solution {
    public int maxRotateFunction(int[] arr) {
        int total=0;
        int ans=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            total+=arr[i];
            ans+=(i*arr[i]);
        }
        int next=ans;
            // System.out.println(ans);
        for(int i=n-1;i>=1;i--){
            next=next+(total-n*arr[i]);
            // System.out.println(next);
            ans=Math.max(ans,next);
        }
        return ans;
    }
    /*
    25+(15-)
F(1) - F(0) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) - (0 * 4) - (1 * 3) - (2 * 2) - (3 * 6)
    // */
    // 25+(15-)
    // 16+(13-6)
    // -3
}
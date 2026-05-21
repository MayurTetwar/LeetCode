class Solution {
    Integer[] memo;
    public int maxJumps(int[] arr, int d) {
        int n=arr.length;
        memo=new Integer[n];
        for(int i=0;i<n;i++){
            if(memo[i]==null){
                helper(arr,i,d);
            }
            // System.out.println(Arrays.toString(memo));
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,memo[i]);
        }
        return max;
    }
    public int helper(int[] arr,int i,int d){
        int n=arr.length;
        if(memo[i]!=null)return memo[i];
        int max=1;
        for(int j=i+1;j<n && j<=i+d;j++){
            if(arr[i]<=arr[j])break;
            max=Math.max(max,helper(arr,j,d)+1);
        }
        for(int j=i-1;j>=0 && i-d<=j;j--){
            if(arr[i]<=arr[j])break;
            max=Math.max(max,helper(arr,j,d)+1);
        }
        return memo[i]=max;
    }
}
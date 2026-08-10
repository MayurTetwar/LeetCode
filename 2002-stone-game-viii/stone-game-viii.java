class Solution {
    public int stoneGameVIII(int[] arr) {
        int n=arr.length;
        for(int i=1;i<n;i++){
            arr[i]+=arr[i-1];
        }
        return helper(arr,1);
    }
    public int helper(int[] arr,int i){
        int n=arr.length;
        if(i==n-1)return arr[n-1];
        int res1=helper(arr,i+1);
        int res2=arr[i]-res1;
        // System.out.println(res1+" "+res2+" "+i);
        return Math.max(res1,res2);
    }
}
class Solution {
    public int maximumSum(int[] arr) {
        int n=arr.length;
        if(n==1)return arr[0];
        int curr=0;
        int[] pre=new int[n];
        Arrays.fill(pre,Integer.MIN_VALUE);
        for(int i=0;i<n;i++){
            curr+=arr[i];
            pre[i]=Math.max(pre[i],curr);
            curr=Math.max(curr,0);
        }
        curr=0;
        int[] suff=new int[n];
        Arrays.fill(suff,Integer.MIN_VALUE);
        for(int i=n-1;i>=0;i--){
            curr+=arr[i];
            suff[i]=Math.max(suff[i],curr);
            curr=Math.max(curr,0);
        }
        int ans=Integer.MIN_VALUE;
        ans=Math.max(pre[1],suff[n-2]);
        ans=Math.max(arr[0],arr[n-1]);
        curr=Math.max(arr[0],0);
        int max=Integer.MIN_VALUE;
        for(int i=1;i<n-1;i++){
            curr+=arr[i];
            max=Math.max(max,curr);
            ans=Math.max(ans,Math.max(pre[i-1]+suff[i+1],max));
            curr=Math.max(0,curr);
        }
        curr+=arr[n-1];
        ans=Math.max(curr,ans);
        // System.out.println(Arrays.toString(pre));
        // System.out.println(Arrays.toString(suff));
        return ans;
    }
}
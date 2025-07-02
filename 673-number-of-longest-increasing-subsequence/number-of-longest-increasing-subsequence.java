class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n=arr.length;
        int[] count=new int[n];
        Arrays.fill(count,1);
        int[] pre=new int[n];
        Arrays.fill(pre,1);
        for(int i=0;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j]<arr[i]){
                    if(pre[i]<pre[j]+1){
                        pre[i]=pre[j]+1;
                        count[i]=count[j];
                    }else if(pre[i]==pre[j]+1){
                        count[i]+=count[j];
                    }
                }
            }
            // [1,2,4,3,5,4,7,2]
            // System.out.println(Arrays.toString(pre));
            // System.out.println(Arrays.toString(count));
            // System.out.println();
        }
        int max=0;
        for(int i=0;i<n;i++)max=Math.max(max,pre[i]);
        int ans=0;
        for(int i=0;i<n;i++){
            if(max==pre[i]){
                ans+=count[i];
            }
        }
        return ans;
    }

}
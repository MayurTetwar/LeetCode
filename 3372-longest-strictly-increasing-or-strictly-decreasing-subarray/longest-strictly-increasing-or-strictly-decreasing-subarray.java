class Solution {
    public int longestMonotonicSubarray(int[] arr) {
        int last=0;
        int n=arr.length;
        int ans=0;
        int i=0;
        while(i<n-1){
            if(arr[i]==arr[i+1]){
                last=i+1;
                i++;
                continue;
            }
            while(i<n-1 && arr[i]<arr[i+1])i++;
            if(i<n && arr[last]!=arr[i]){
                ans=Math.max(ans,i-last+1);
                last=i;
            }
            while(i<n-1 && arr[i]>arr[i+1])i++;
            if(i<n && arr[last]!=arr[i]){
                ans=Math.max(ans,i-last+1);
                last=i;
            }
            //System.out.println(ans+" "+last+" "+i);
        }
        ans=Math.max(ans,1);
        return ans;
    }
}
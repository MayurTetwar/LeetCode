class Solution {
    public long maxSumTrionic(int[] arr) {
        int n=arr.length;
        
        int i=0;
        while(i<n-1 && arr[i]>=arr[i+1]){
            i++;
        }
        while(i<n-1 && arr[i]<arr[i+1])i++;
        long ans=Long.MIN_VALUE;

        while(i<n-1){
            // 1.
            long prev=arr[i]+arr[i-1];
            for(int p=i-1;p>0 && arr[p-1]<arr[p];p--){
                prev=Math.max(prev,prev+arr[p-1]);
            }
            // skip
            if(i<n-1 && arr[i]==arr[i+1]){
                while(i<n-1 && arr[i]>=arr[i+1])i++;
                while(i<n-1 && arr[i]<arr[i+1])i++;
                continue;
            }
            // 2.
            long curr=0;
            while(i<n-1 && arr[i]>arr[i+1]){
                curr+=arr[i+1];
                i++;
            }
            // skip
            if(i<n-1 && arr[i]==arr[i+1]){
                while(i<n-1 && arr[i]>=arr[i+1])i++;
                while(i<n-1 && arr[i]<arr[i+1])i++;
                continue;
            }
            long next=0;
            int st=i+1;
            // 3.
            while(i<n-1 && arr[i]<arr[i+1]){
                next+=arr[i+1];
                i++;
            }
            if(st<n)ans=Math.max(ans,prev+curr+Math.max(next,arr[st]));
        }
        return ans;
    }
}
// [0 > -2 < -1 > -3 < 0 < 2 > -1]
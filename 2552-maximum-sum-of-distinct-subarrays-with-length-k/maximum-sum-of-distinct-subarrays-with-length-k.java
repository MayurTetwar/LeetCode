class Solution {
    public long maximumSubarraySum(int[] arr, int k) {
        int[] count=new int[100001];
        int extra=0;
        int n=arr.length;
        long sum=0;
        long curr=0;
        for(int i=0;i<k;i++){
            if(count[arr[i]]>0){
                extra++;
            }
            count[arr[i]]++;
            curr+=arr[i];
        }
        if(n==k)return (extra==0)?curr:0;
        if(extra==0)sum=Math.max(sum,curr);
        for(int i=k;i<n;i++){
            if(count[arr[i]]>0){
                extra++;
            }
            count[arr[i]]++;
            if(count[arr[i-k]]>1){
                extra--;
            }
            count[arr[i-k]]--;
            curr+=arr[i];
            curr-=arr[i-k];
            // System.out.println(extra+" "+curr);
            if(extra==0){
                sum=Math.max(sum,curr);
            }
        }
        return sum;
    }
}
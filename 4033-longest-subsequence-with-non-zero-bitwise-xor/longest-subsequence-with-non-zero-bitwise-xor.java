class Solution {
    public int longestSubsequence(int[] arr) {
        int n=arr.length;
        long curr=arr[0];
        // if(n==0 && arr[0]==0)return 1;
        for(int i=1;i<n;i++){
            curr=curr^arr[i];
        }
        if(curr==0){
            boolean flag=true;
            for(int i=0;i<n;i++){
                if(arr[i]!=0){
                    flag=false;
                    break;
                }
            }
            if(flag)return 0;
            return n-1;
        }
        return n;
    }
}
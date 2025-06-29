class Solution {
    public int numSubseq(int[] arr, int tar) {
        int n=arr.length;
        Arrays.sort(arr);
        int st=0,end=n-1;
        int ans=0;
        int mod=1000000007;
        int[] pow=new int[n];
        pow[0]=1;
        for(int i=1;i<n;i++){
            pow[i]=(2*pow[i-1])%mod;
        }
        while(st<=end){
            if(arr[st]+arr[end]<=tar){
                ans=(ans+pow[end-st])%mod;
                st++;
            }else{
                end--;
            }
        }
        return ans;
    }
}
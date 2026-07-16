class Solution {
    public long gcdSum(int[] arr ) {
        int n=arr.length;
        long[] g=new long[n];
        int max=arr[0];
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
            g[i]=gcd(arr[i],max);
        }
        Arrays.sort(g);
        int i=0;
        int j=n-1;
        long ans=0;
        while(i<j){
            ans+=gcd(g[i],g[j]);
            i++;
            j--;
        }
        return ans;
    }
     public long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
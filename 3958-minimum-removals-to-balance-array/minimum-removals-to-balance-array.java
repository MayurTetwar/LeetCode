class Solution {
    public int minRemoval(int[] arr, int k) {
        int n=arr.length;
        int ans=n;
        if(n==1)return 0;
        Arrays.sort(arr);
        int j=0;
        for(int i=0;i<n;i++){
            while(j<n-1 && (long)arr[i]*k>=arr[j+1])j++;
            if(i<=j)ans=Math.min(ans,n-j-1+i);
        }
        return ans;
    }
}
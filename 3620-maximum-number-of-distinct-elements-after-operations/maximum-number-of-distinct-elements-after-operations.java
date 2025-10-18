class Solution {
    public int maxDistinctElements(int[] arr, int k) {
        int n=arr.length;
        Arrays.sort(arr);
        int[] ans=new int[n];
        int cnt=1;
        ans[0]=arr[0]-k;
        for(int i=1;i<n;i++){
            if(arr[i]==arr[i-1]){
                ans[i]=Math.min(ans[i-1]+1,arr[i]+k);
            }else{
                ans[i]=Math.max(arr[i]-k,ans[i-1]+1);
            }
            if(ans[i-1]!=ans[i])cnt++;
        }
        return cnt;
    }
}
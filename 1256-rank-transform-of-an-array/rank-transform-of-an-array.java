class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        Integer[] idx=new Integer[n];
        for(int i=0;i<n;i++){
            idx[i]=i;
        }
        Arrays.sort(idx, (a, b) -> Integer.compare(arr[a], arr[b]));
        int curr=0;
        int prev=(int)1e9+7;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            if(prev!=arr[idx[i]]){
                prev=arr[idx[i]];
                curr++;
            }
            ans[idx[i]]=curr;
        }
        return ans;
    }
}
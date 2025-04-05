class Solution {
    int ans;
    public int subsetXORSum(int[] arr) {
        ans=0;
        helper(arr,0,0);
        return ans;
    }
    public void helper(int[] arr,int curr,int idx){
        if(idx==arr.length){
            ans+=curr;
            return;
        }
        helper(arr,curr,idx+1);
        helper(arr,curr^arr[idx],idx+1);
    }
}
class Solution {
    public int subsetXORSum(int[] arr) {
        return helper(arr,0,0);
    }
    public int helper(int[] arr,int curr,int idx){
        if(idx==arr.length){
            return curr;
        }
        return helper(arr,curr,idx+1)+helper(arr,curr^arr[idx],idx+1);
    }
}
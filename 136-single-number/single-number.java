class Solution {
    public int singleNumber(int[] arr) {
        int ans=0;
        for(int num:arr){
            ans=ans^num;
        }
        return ans;
    }
}
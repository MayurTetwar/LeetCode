class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int xor=arr1[0];
        for(int i=1;i<arr1.length;i++){
            xor^=arr1[i];
        }
        int ans=0;
        for(int i=0;i<arr2.length;i++){
            ans=ans^(xor & arr2[i]);
        }
        return ans;
    }
}
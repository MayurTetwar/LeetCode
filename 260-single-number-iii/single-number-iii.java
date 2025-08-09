class Solution {
    public int[] singleNumber(int[] arr) {
        int xor=0;
        for(int num:arr){
            xor^=num;
        }
        int msb=31 - Integer.numberOfLeadingZeros(xor);
        int[] ans=new int[2];
        for(int num:arr){
            if((num&(1<<msb))==0){
                ans[0]^=num;
            }else{
                ans[1]^=num;
            }
        }
        return ans;
    }
}
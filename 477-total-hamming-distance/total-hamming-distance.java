class Solution {
    public int totalHammingDistance(int[] arr) {
        int[] bit=new int[32];
        int n=arr.length;
        for(int num:arr){
            for(int i=0;i<32;i++){
                if((num&(1<<i))!=0){
                    bit[i]++;
                }
            }
        }
        // System.out.println(Arrays.toString(bit));
        int ans=0;
        for(int i=0;i<32;i++){
            ans+=(bit[i]*(n-bit[i]));
        }
        return ans;
    }
}
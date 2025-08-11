class Solution {
    public int[] productQueries(int n, int[][] arr) {
        int msb=31-Integer.numberOfLeadingZeros(n);
        long mod=1000000007;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<=msb;i++){
            if((n&(1<<i))!=0){
                list.add((1<<i));
            }
        }
        int[] ans=new int[arr.length];
        int ind=0;
        for(int[] q:arr){
            long val=1;
            for(int i=q[0];i<=q[1];i++){
                val=(val*list.get(i))%mod;
            }
            ans[ind++]=(int)val;
        }
        return ans;
    }
}
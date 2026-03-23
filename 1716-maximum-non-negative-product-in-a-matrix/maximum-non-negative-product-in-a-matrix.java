// class Solution {
//     long mod=1000000007;
//     Long[][] memo;
//     public int maxProductPath(int[][] arr) {
//         memo=new Long[arr.length][arr[0].length];
//         long ans=helper(arr,0,0);
//         for(Long[] me:memo){
//             System.out.println(Arrays.toString(me));
//         }
//         if(ans<0)return -1;
//         return (int)ans;
//     }
//     public long helper(int[][] arr,int i,int j){
//         if(i==arr.length-1 && j==arr[0].length-1){
//             return (long)arr[i][j];
//         }
//         if(memo[i][j]!=null)return memo[i][j];
//         long res=Integer.MIN_VALUE;
//         if(i<arr.length-1){
//             res=Math.max(res,(helper(arr,i+1,j)*arr[i][j])%mod);
//         }
//         if(j<arr[0].length-1){
//             res=Math.max(res,(helper(arr,i,j+1)*arr[i][j])%mod);
//         }
//         return memo[i][j]=res;
//     }
// }

class Solution {
    long mod=1000000007;
    long[][][] memo;
    boolean[][] visi;
    public int maxProductPath(int[][] arr) {
        memo=new long[arr.length][arr[0].length][2];
        visi=new boolean[arr.length][arr[0].length];
        long[] ans=helper(arr,0,0);
        for(long[][] me:memo){
            System.out.println(Arrays.deepToString(me));
        }
        if(Math.max(ans[0],ans[1])<0)return -1;
        return (int)(Math.max(ans[0],ans[1])%mod);
    }
    public long[] helper(int[][] arr,int i,int j){
        if(i==arr.length-1 && j==arr[0].length-1){
            return new long[]{arr[i][j],arr[i][j]};
        }
        if(visi[i][j])return memo[i][j];
        long res=0;
        long res2=0;
        long[] r1={Long.MIN_VALUE,Long.MAX_VALUE};
        long[] r2={Long.MIN_VALUE,Long.MAX_VALUE};
        if(i<arr.length-1){
            r1=helper(arr,i+1,j);
        }
        if(j<arr[0].length-1){
            r2=helper(arr,i,j+1);
        }
        if(arr[i][j]<0){
            res=arr[i][j]*Math.min(r1[1],r2[1]);
            res2=arr[i][j]*Math.max(r1[0],r2[0]);
        }else{
            res=arr[i][j]*Math.max(r1[0],r2[0]);
            res2=arr[i][j]*Math.min(r1[1],r2[1]);
        }
        visi[i][j]=true;
        return memo[i][j]=new long[]{res,res2};
    }
}

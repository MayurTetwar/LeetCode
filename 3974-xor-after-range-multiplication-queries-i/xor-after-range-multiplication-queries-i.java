class Solution {
    public int xorAfterQueries(int[] arr, int[][] queries) {
        int n=arr.length;
        long[] cal=new long[n];
        for(int i=0;i<n;i++)cal[i]=(long)arr[i];
        for(int[] q:queries){
            int st=q[0];
            int end=q[1];
            for(int i=st;i<=end;i+=q[2]){
                cal[i]=(cal[i]*q[3])%1000000007;
            }
        }
        long ans=0;
        for(int i=0;i<n;i++)ans=ans^cal[i];
        return (int)ans;
    }
}
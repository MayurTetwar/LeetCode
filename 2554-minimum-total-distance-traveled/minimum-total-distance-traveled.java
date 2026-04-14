class Solution {
    long[][] memo;
    public long minimumTotalDistance(List<Integer> rob, int[][] arr) {
        int n=rob.size();        
        Collections.sort(rob);
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        
        List<Integer> list=new ArrayList<>();
        for(int[] a:arr){
            for(int i=0;i<a[1];i++){
                list.add(a[0]);
            }
        }
        memo=new long[n][list.size()];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        return helper(rob,list,0,0);
    }   
    public long helper(List<Integer> rob,List<Integer> fac,int i,int j){
        if(i==rob.size())return 0;    
        if(j==fac.size())return (long)1e17;
        if(memo[i][j]!=-1)return memo[i][j];    

        long res1=helper(rob,fac,i,j+1);
        long res2=Math.abs(rob.get(i)-fac.get(j))+helper(rob,fac,i+1,j+1);
        return memo[i][j]=Math.min(res1,res2);
    }
}
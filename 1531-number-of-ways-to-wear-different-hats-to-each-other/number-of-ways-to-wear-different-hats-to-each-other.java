class Solution {
    int allmask;
    long[][] memo;
    int mod=1000000007;
    public int numberWays(List<List<Integer>> hats) {
        List<List<Integer>> map=new ArrayList<>();
        int max=0;
        allmask=(1<<hats.size());
        for(List<Integer> per:hats){
            for(int h:per){
                max=Math.max(max,h);
            }
        }
        memo=new long[max+1][allmask];
        for(int i=0;i<=max;i++){
            map.add(new ArrayList<>());
            Arrays.fill(memo[i],-1);
        }
        int i=0;
        for(List<Integer> per:hats){
            for(int h:per){
                map.get(h).add(i);
            }
            i++;
        }  
        return (int)helper(map,1,0);
    }
    public long helper(List<List<Integer>> map,int i,int mask){
        if(mask==allmask-1){
            return 1;
        }
        if(i==map.size()){
            return 0;
        }
        if(memo[i][mask]!=-1) return memo[i][mask];
        long res2=helper(map,i+1,mask);
        long res=0;
        for(int p:map.get(i)){
            if((mask&(1<<p))==0){
                res+=helper(map,i+1,mask|(1<<p));
            }
        }
        return (memo[i][mask]=(res+res2)%mod);
    }
}
class Solution {
    String num;
    Integer[][][][] memo;
    public int countNumbersWithUniqueDigits(int n) {
        int limit =(int)Math.pow(10,n)-1;
        // System.out.println(limit);
        num=String.valueOf(limit);
        memo=new Integer[num.length()][2][(1<<10)][2];
        return helper(0,1,0,0);
    }
    public int helper(int pos,int tight,int mask,int started){
        // System.out.println(pos+" "+mask);
        if(pos==num.length())return 1;
        if(memo[pos][tight][mask][started]!=null)return memo[pos][tight][mask][started];
        int limit = (tight==1)?num.charAt(pos)-'0':9;
        int ans=0;
        if(started==0){
            int newtight=(tight==1 && limit==0)?1:0;
            ans+=helper(pos+1,newtight,mask,0);
        }
        int st=(started==0)?1:0;
        for(int i=st;i<=limit;i++){
            if((mask&(1<<i))!=0)continue;
            int newtight = (tight==1 && i==limit)?1:0;
            ans+=helper(pos+1,newtight,mask|(1<<i),1);
        }
        return memo[pos][tight][mask][started]=ans;
    }
}
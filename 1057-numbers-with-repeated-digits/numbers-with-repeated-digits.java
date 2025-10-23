class Solution {
    String num;
    int len;
    Integer[][][][][] memo;
    public int numDupDigitsAtMostN(int n) {
        num=String.valueOf(n);
        len=num.length();
        memo=new Integer[len][2][2][1025][2];
        return helper(0,1,0,0,0);
    }   
    public int helper(int pos,int tight,int started,int mask,int rep){
        if(pos==len){
            return started & rep;
        }
        if(memo[pos][tight][started][mask][rep]!=null)return memo[pos][tight][started][mask][rep];
        int limit=(tight==1)?num.charAt(pos)-'0':9;
        int res=0;
        for(int i=0;i<=limit;i++){
            int newtight=(tight==1 && i==limit)?1:0;
            int newstarted=(started==0 && i==0)?0:1;
            int newmask=mask;
            if(newstarted==1)newmask=mask|(1<<i);
            int newrep=(rep==1 || (newstarted==1 && (mask&(1<<i))!=0))?1:0;
            res+=helper(pos+1,newtight,newstarted,newmask,newrep);
        }
        return memo[pos][tight][started][mask][rep]=res;
    }
}
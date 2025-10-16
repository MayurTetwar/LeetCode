class Solution {
    Integer[][][][][][] memo;
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        int len=String.valueOf(high).length();
        memo=new Integer[len][2][k][len][len][2];
        int ans1=helper(String.valueOf(high),k,0,1,0,0,0,0);
        memo=new Integer[len][2][k][len][len][2];
        int ans2=helper(String.valueOf(low-1),k,0,1,0,0,0,0);
        return ans1-ans2;
    }
    public int helper(String num,int k,int pos,int tight,int mod,int odd,int even,int started){
        if(num.length()==pos){
            return (started==1 && odd==even && mod==0)?1:0;
        }
        if(memo[pos][tight][mod][odd][even][started]!=null)return memo[pos][tight][mod][odd][even][started];
        int limit = (tight==1)?num.charAt(pos)-'0':9;
        int ans=0;
        for(int i=0;i<=limit;i++){
            int newtight=(tight==1 && i==limit)?1:0;
            int newst = (started == 0 && i == 0) ? 0 : 1;
            int newodd = odd + ((i % 2 == 1 && newst == 1) ? 1 : 0);
            int neweven = even + ((i % 2 == 0 && newst == 1) ? 1 : 0);
            int newmod = newst == 1 ? (mod * 10 + i) % k : mod;
            ans+=helper(num,k,pos+1,newtight,newmod,newodd,neweven,newst);
        }
        return memo[pos][tight][mod][odd][even][started]=ans;
    }
}
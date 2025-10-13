class Solution {
    String num;
    Integer[][][] memo;
    public int countDigitOne(int n) {
        num = String.valueOf(n);
        memo=new Integer[11][2][11];
        return helper(0,1,0);
    }
    public int helper(int pos,int tight,int cnt){
        if(pos==num.length()){
            return cnt;
        }
        if(memo[pos][tight][cnt]!=null)return memo[pos][tight][cnt]; 
        int limit = (tight == 1)?num.charAt(pos)-'0':9;
        int ans=0;
        for(int dig=0;dig<=limit;dig++){
            int newtight = (tight==1 && dig==limit)?1:0;
            int upcnt = cnt+((dig==1)?1:0);
            ans+=helper(pos+1,newtight,upcnt);
        }
        return memo[pos][tight][cnt]=ans;
    }
}
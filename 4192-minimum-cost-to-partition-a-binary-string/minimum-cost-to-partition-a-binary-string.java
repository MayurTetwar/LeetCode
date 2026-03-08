class Solution {
    public long minCost(String s, int enc, int flat) {
        int n=s.length();
        return helper(s,0,n-1,enc,flat);
    }
    public long helper(String s,int l,int r,int enc,int flat){
        long count=0;
        for(int i=l;i<=r;i++){
            if(s.charAt(i)=='1')count++;
        }
        // System.out.println(count+" "+l+" "+r);
        if(count==0)return flat;
        if((r-l+1)%2==1){
            return (r-l+1)*count*enc;
        }else{
            return Math.min((r-l+1)*count*enc,helper(s,l,(r+l)/2,enc,flat)+helper(s,((r+l)/2)+1,r,enc,flat));
        }
    }
}
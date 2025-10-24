class Solution {
    long mod=1000000007;
    Long[][][] memo;
    public int count(String num1, String num2, int mins, int maxs) {
        memo=new Long[num2.length()][2][23*9];
        long ans2=helper(num2,0,1,0,mins,maxs);
        StringBuilder sb=new StringBuilder();
        boolean flag=false;
        for(int i=num1.length()-1;i>=0;i--){
            if(flag){
                sb.append(num1.charAt(i));
                continue;
            }
            if(num1.charAt(i)=='0'){
                sb.append(9);
            }else{
                flag=true;
                sb.append((num1.charAt(i)-'0')-1);
            }
        }
        memo=new Long[num1.length()][2][23*9];
        long ans1=helper(sb.reverse().toString(),0,1,0,mins,maxs);
        // System.out.println(ans2+" "+ans1);
        return (int)((ans2-ans1+mod)%mod);
    }
    public long helper(String num,int pos,int tight,int sum,int mins,int maxs){
        if(sum>maxs)return 0L;
        if(pos==num.length()){
            return (sum>=mins)?1L:0L;
        }  
        if(memo[pos][tight][sum]!=null)return memo[pos][tight][sum];
        int limit=(tight==1)?num.charAt(pos)-'0':9;
        long res=0;
        for(int i=0;i<=limit;i++){
            int newtight=(tight==1 && i==limit)?1:0;
            res=(res+helper(num,pos+1,newtight,sum+i,mins,maxs))%mod;
        }
        return memo[pos][tight][sum]=res;
    }
}
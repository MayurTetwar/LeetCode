class Solution {
    public int[] sumAndMultiply(String s, int[][] que) {
        int n=s.length();
        long[] str=new long[n];
        long[] sum=new long[n];
        int[] len=new int[n];
        long num=0;
        long su=0;
        long mod=1000000007;
        int l=0;
        for(int i=0;i<n;i++){
            int val=s.charAt(i)-'0';
            su=(su+val)%mod;
            sum[i]=su;
            if(val>0){
                num=num*10+val;
                num=num%mod;
                l++;
            }
            len[i]=l;
            str[i]=num;
        }
        int[] ans=new int[que.length];
        for(int i=0;i<que.length;i++){
            int left=que[i][0];
            int right=que[i][1];
            long cs=sum[right]-((left>0)?sum[left-1]:0);
            long snd=str[right];
            if(left==0){
                ans[i]=(int)powerMod(snd*cs,1,mod);
                continue;
            }
            long frt=str[left-1];
            long ten=powerMod(10,len[right]-((left>0)?len[left-1]:0),mod);
            long reduce=(ten*frt)%mod;
            // System.out.println(frt+" "+ten+" "+cs+" "+snd+" "+reduce+" "+i);
            // System.out.println((snd+mod)%mod);
            ans[i]=(int)(((snd-reduce+mod)%mod)*cs%mod);
        }
        return ans;
    }
    public long powerMod(long base, long exponent, long mod) {
        long result = 1;
        base = base % mod;
        while (exponent > 0) {
            if ((exponent & 1) == 1)result = (result * base) % mod;
            base = (base * base) % mod;
            exponent >>= 1;  
        }
        return result;
    }
}
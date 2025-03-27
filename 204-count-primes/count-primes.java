class Solution {
    static boolean[] arr;
    static int[] ans;
    static{
        arr=new boolean[5000001];
        ans=new int[5000001];
        ans[3]=1;
        for (int i = 2; i < 5000001; i++) {
            if (!arr[i]) {
                ans[i]=ans[i-1]+1;
                for(long j=(long)i*i;j<5000001;j+=i){
                    arr[(int)j]=true;
                }
            }else{
                ans[i]=ans[i-1];
            }
        }
    }    
    public static int countPrimes(int n) { 
        if(n<=2)return 0;   
        return ans[n-1];
    }
}
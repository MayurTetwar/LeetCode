class Solution {
    static int[] ans;
    static boolean flag;
    public static void helper(){
        if(flag)return;
        flag=true;
        ans=new int[5000001];
        boolean[] arr=new boolean[5000001];
        ans[3]=1;
        for (int i = 2; i < 5000001; i++) {
            if (!arr[i]) {
                for(long j=(long)i*i;j<5000001;j+=i){
                    arr[(int)j]=true;
                }
            }
        }
        for(int i=2;i<5000001;i++){
            if(!arr[i]){
                ans[i]=ans[i-1]+1;
            }else{
                ans[i]=ans[i-1];
            }
        }
    }    
    public static int countPrimes(int n) { 
        if(n<=2)return 0;   
        helper();
        return ans[n-1];
    }
}
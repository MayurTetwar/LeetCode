class Solution {
    long[][] memo;
    long mod=1000000007;
    public int countArrays(int[] arr) {
        int n=arr.length;
        memo=new long[n][5001];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        return (int)helper(arr,n,0,0);
    }
    public long helper(int[] arr,int n,int i,int num){
        if(i==n)return 1;
        if(memo[i][num]!=-1)return memo[i][num];

        long res=0;
        if(num<5000){
            res=(res+helper(arr,n,i,num+1))%mod;
        }
        if(arr[i]==digSum(num)){
            res=(res+helper(arr,n,i+1,num))%mod;
        }
        return memo[i][num]=res;
    }
    public int digSum(int num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}
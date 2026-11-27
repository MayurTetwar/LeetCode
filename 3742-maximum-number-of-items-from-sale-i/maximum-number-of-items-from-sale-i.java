class Solution {
    int[][][] memo;
    public int maximumSaleItems(int[][] arr, int budget) {
        int n=arr.length;
        int[] divPrice=new int[n];
        memo=new int[n][budget+1][2];
        for(int i=0;i<n;i++){
            for(int[] ar:memo[i]){
                Arrays.fill(ar,-1);
            }
            int total=0;
            for(int j=0;j<n;j++){
                if(i==j)continue;
                if(arr[j][0]%arr[i][0]==0){
                    divPrice[i]++;
                }
            }
        }
        return helper(arr,divPrice,0,budget,0);
    }
    public int helper(int[][] arr,int[] divPrice,int i,int budget,int getfree){
        int n=arr.length;
        if(n==i)return 0;
        if(memo[i][budget][getfree]!=-1)return memo[i][budget][getfree];
        int res1=helper(arr,divPrice,i+1,budget,0);
        int res2=0;
        if(arr[i][1]<=budget){
            if(getfree==0)res2=divPrice[i];
            res2+=1+helper(arr,divPrice,i,budget-arr[i][1],1);
        }
        return memo[i][budget][getfree]=Math.max(res1,res2);
    }
}
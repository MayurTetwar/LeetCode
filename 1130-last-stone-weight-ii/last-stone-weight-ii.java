class Solution {
    int total;
    int[][] memo;
    public int lastStoneWeightII(int[] arr) {
        total=0;
        int n=arr.length;
        for(int num:arr){
            total+=num;
        }
        memo=new int[n][total+1];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        return helper(arr,0,0);
    }
    public int helper(int[] arr,int i,int sum){
        if(i==arr.length){
            return Math.abs(total-sum*2);
        }
        if(memo[i][sum]!=-1)return memo[i][sum];
        int val1=helper(arr,i+1,sum+arr[i]);
        int val2=helper(arr,i+1,sum);
        return memo[i][sum]=Math.min(val1,val2);
    }
}
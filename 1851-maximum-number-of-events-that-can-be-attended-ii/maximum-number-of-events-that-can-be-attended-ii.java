class Solution {
    int[][] memo;
    public int maxValue(int[][] arr, int k) {
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int n=arr.length;
        memo=new int[n][k+1];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1);
        }
        return helper(arr,0,k);
    }
    public int helper(int[][] arr,int i,int k){
        if(k==0 || arr.length==i){
            return 0;
        }
        if(memo[i][k]!=-1)return memo[i][k];
        int nextInd=BS(arr,arr[i][1]);
        int val1=helper(arr,i+1,k);
        int val2=arr[i][2]+helper(arr,nextInd,k-1); 
        return memo[i][k]=Math.max(val1,val2);
    }
    public int BS(int[][] arr,int tar){
        int st=0;
        int end=arr.length;
        while(st<end){
            int mid=st+(end-st)/2;
            if(arr[mid][0]<=tar){
                st=mid+1;
            }else{
                end=mid;
            }
        }
        return st;
    }
}
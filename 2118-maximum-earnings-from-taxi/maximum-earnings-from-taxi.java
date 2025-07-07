class Solution {
    long[] memo;
    public long maxTaxiEarnings(int n, int[][] arr) {
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        memo=new long[arr.length];
        Arrays.fill(memo,-1);
        return helper(arr,0);
    }
    public long helper(int[][] arr,int i){
        if(i==arr.length)return 0;
        if(memo[i]!=-1)return memo[i];
        int next=BS(arr,arr[i][1]);
        long val1=helper(arr,i+1);
        long mon=(arr[i][1]-arr[i][0])+arr[i][2];
        long val2=mon+helper(arr,next);
        return memo[i]=Math.max(val1,val2);
    }
    public int BS(int[][] arr,int tar){
        int st=0,end=arr.length;
        while(st<end){
            int mid=st+(end-st)/2;
            if(arr[mid][0]<tar){
                st=mid+1;
            }else{
                end=mid;
            }
        }
        return st;
    }
}
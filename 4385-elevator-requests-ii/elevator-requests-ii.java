class Solution {
    Long[][][] memo;
    public long elevatorRequests(int n, int start, int[] arr) {
        int m=arr.length;
        memo=new Long[m+1][m+1][2];
        int[] arr2=new int[m+1];
        for(int i=0;i<m;i++){
            arr2[i]=arr[i];
        }
        arr2[m]=start;
        Arrays.sort(arr2);
        int idx=0;
        for(int i=0;i<=m;i++){
            if(arr2[i]==start){
                idx=i;
                break;
            }
        }
        return helper(arr2,idx,idx,0);
    }
    public long helper(int[] arr,int i,int j,int pos){
        int n=arr.length;
        if(i==0 && j==n-1)return 0;
        if(memo[i][j][pos]!=null)return memo[i][j][pos];
        int rem=n-(j-i+1);
        long currpos=(pos==0)?arr[i]:arr[j];
        
        long res=(long)1e18;
        
        if(i>0){
            long val=Math.abs(currpos-arr[i-1])*rem;
            res=Math.min(res,val+helper(arr,i-1,j,0));
        }
        if(j+1<n){
            long val=Math.abs(currpos-arr[j+1])*rem;
            res=Math.min(res,val+helper(arr,i,j+1,1));
        }
        return memo[i][j][pos]=res;
    }
}
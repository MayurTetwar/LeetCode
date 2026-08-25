class Solution {
    int[] memo;
    public int maxHeight(int[][] arr) {
        int n=arr.length;
        memo=new int[n+1];
        int[][] brr=new int[n+1][3];
        Arrays.fill(memo,-1);
        int i=1;
        brr[0]=new int[]{0,0,0};
        for(int[] a:arr){
            Arrays.sort(a);
            brr[i]=a;
            i++;
        }
        Arrays.sort(brr,(a,b)->{
            if(a[0]!=b[0])return a[0]-b[0];
            if(a[1]!=b[1])return a[1]-b[1];
            return a[2]-b[2];
        });
        return helper(brr,0);
    }
    public int helper(int[][] arr,int i){
        int n=arr.length;
        if(memo[i]!=-1)return memo[i];
        int ans=0;
        int[] up=arr[i];
        for(int j=i+1;j<n;j++){
            int[] down=arr[j];  
            if(up[0]<=down[0] && up[1]<=down[1] && up[2]<=down[2]){
                ans=Math.max(ans,helper(arr,j)+down[2]);
            }
        }
        return memo[i]=ans;
    }
}
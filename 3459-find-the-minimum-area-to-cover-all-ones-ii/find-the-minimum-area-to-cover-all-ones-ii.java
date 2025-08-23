class Solution {
    public int minimumSum(int[][] arr) {       
        int[][] rev=reverse(arr);
        return Math.min(helper(rev),helper(arr));
    }
    public int helper(int[][] arr){
        int n=arr.length;
        int m=arr[0].length;
        int ans=n*m;
        for(int i=0;i+1<n;i++){
            for(int j=0;j+1<m;j++){
                int val1=minimumArea(arr,0,i,0,m-1);
                int val2=minimumArea(arr,i+1,n-1,0,j);
                int val3=minimumArea(arr,i+1,n-1,j+1,m-1);
                ans=Math.min(ans,val1+val2+val3);
                val1=minimumArea(arr,0,i,0,j);
                val2=minimumArea(arr,0,i,j+1,m-1);
                val3=minimumArea(arr,i+1,n-1,0,m-1);
                ans=Math.min(ans,val1+val2+val3);
            }
        }
        for(int i=0;i+1<n;i++){
            for(int j=i+1;j+1<n;j++){
                int val1=minimumArea(arr,0,i,0,m-1);
                int val2=minimumArea(arr,i+1,j,0,m-1);
                int val3=minimumArea(arr,j+1,n-1,0,m-1);
                ans=Math.min(ans,val1+val2+val3);
            }
        }
        return ans;
    }
    public int[][] reverse(int[][] arr){
        int n=arr.length;
        int m=arr[0].length;
        int[][] rev=new int[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                rev[m-j-1][i]=arr[i][j];
            }
        }
        return rev;
    }
    public int minimumArea(int[][] arr,int st1,int end1,int st2,int end2) {
        int n=arr.length;
        int m=arr[0].length;
        int top=n;
        int bottom=-1;
        int left=n;
        int right=-1;
        for(int i=st1;i<=end1;i++){
            for(int j=st2;j<=end2;j++){
                if(arr[i][j]==1){
                    top=Math.min(top,i);
                    bottom=Math.max(bottom,i);
                    left=Math.min(left,j);
                    right=Math.max(right,j);
                }
            }
        }
        if(right==-1)return Integer.MAX_VALUE/3;
        return (right-left+1)*(bottom-top+1);
    } 
}
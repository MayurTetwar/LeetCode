class Solution {
    int num;
    int count;
    public int uniquePathsIII(int[][] arr) {
        num=0;
        int n=arr.length;
        int m=arr[0].length;
        count=n*m-1;
        int st=-1, st2=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    st=i;
                    st2=j;
                }
                if(arr[i][j]==-1)count--;
            }
        }
        // System.out.println(st+" "+st2);
        helper(arr,st,st2,new boolean[arr.length][arr[0].length]);
        return num;
    }
    public void helper(int[][] arr,int i,int j,boolean[][] visi){
        if(!valid(arr,i,j) || visi[i][j] || arr[i][j]==-1){
            return ;
        }
        if(arr[i][j]==2 && count==0){
            num++;
            return ;
        }
        visi[i][j]=true;
        count--;
        helper(arr,i+1,j,visi);
        helper(arr,i,j+1,visi);
        helper(arr,i-1,j,visi);
        helper(arr,i,j-1,visi);
        visi[i][j]=false;
        count++;
    }
    public boolean valid(int[][] arr,int i,int j){
        if(i>=arr.length || j>=arr[0].length || i<0 || j<0){
            return false;
        }
        return true;
    }
}
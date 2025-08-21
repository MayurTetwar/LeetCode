class Solution {
    public int numberOfSubmatrices(char[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int ans=0;
        int[][] dpx=new int[n][m];
        int[][] dpy=new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(j>0){
                    dpx[i][j]=dpx[i][j-1];
                    dpy[i][j]=dpy[i][j-1];
                }   
                if(i>0){
                    dpx[i][j]+=dpx[i-1][j];
                    dpy[i][j]+=dpy[i-1][j];
                }
                if(i>0 && j>0){
                    dpx[i][j]-=dpx[i-1][j-1];
                    dpy[i][j]-=dpy[i-1][j-1];
                }
                if(arr[i][j]=='X')dpx[i][j]++;
                else if(arr[i][j]=='Y')dpy[i][j]++;
                if(dpx[i][j]==dpy[i][j] && dpx[i][j]>0){
                    ans++;
                }
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.print(dpx[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.print(dpy[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return ans;
    }
}
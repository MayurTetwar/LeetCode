class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] arr=new int[m][n];
        boolean[][] visi=new boolean[m][n];
        for(int[] g:guards){
            arr[g[0]][g[1]]=1;
            visi[g[0]][g[1]]=true;
        }
        for(int[] w:walls){
            arr[w[0]][w[1]]=2;
            visi[w[0]][w[1]]=true;
        }
        // left to right
        for(int i=0;i<m;i++){
        boolean flag=false;
            for(int j=0;j<n;j++){
                if(arr[i][j]==2)flag=false;
                else if(arr[i][j]==1)flag=true;
                else if(flag)visi[i][j]=true;
            }
        }
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(visi[i][j]+" ");
        //     }
                // //System.out.println();
        // }
        // right to left
        for(int i=0;i<m;i++){
        boolean flag=false;

            for(int j=n-1;j>=0;j--){
                if(arr[i][j]==2)flag=false;
                else if(arr[i][j]==1)flag=true;
                else if(flag)visi[i][j]=true;
            }
        }
                //System.out.println();
// for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 System.out.print(visi[i][j]+" ");
//             }
                // //System.out.println();
//         }
                //System.out.println();

        // up to down
        for(int i=0;i<n;i++){
        boolean flag=false;

            for(int j=0;j<m;j++){
                if(arr[j][i]==2)flag=false;
                else if(arr[j][i]==1)flag=true;
                else if(flag)visi[j][i]=true;
            }
        }
                //System.out.println();
    // for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             System.out.print(visi[i][j]+" ");
    //         }
                // //System.out.println();
    //     }
        // down to up
        for(int i=0;i<n;i++){
        boolean flag=false;

            for(int j=m-1;j>=0;j--){
                if(arr[j][i]==2)flag=false;
                else if(arr[j][i]==1)flag=true;
                else if(flag)visi[j][i]=true;
            }
        }
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(visi[i][j]+" ");
        //     }
                // //System.out.println();
        // }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visi[i][j])ans++;
            }
        }
        return ans;
    }
    // for(int i=0;i<m;i++){
    //         for(int j=0;j<n;j++){
    //             System.out.print(visi[i][j]+" ");
    //         }
                // //System.out.println();
    //     }
}
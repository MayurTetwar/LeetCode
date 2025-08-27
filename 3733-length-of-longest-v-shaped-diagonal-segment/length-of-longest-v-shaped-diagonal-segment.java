class Solution {
    public int lenOfVDiagonal(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int ans=0;
        int[][] rb=new int[n][m];
        boolean[][] onerb=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                rb[i][j]=1;
                if(i==0 || j==0){
                    if(arr[i][j]==1){
                        onerb[i][j]=true;
                        ans=1;
                    }
                    continue;
                }
                if(arr[i][j]==0){
                    if(arr[i-1][j-1]==2){
                        rb[i][j]=rb[i-1][j-1]+1;
                        onerb[i][j]=onerb[i-1][j-1];
                    }
                }else if(arr[i][j]==2){
                    if(arr[i-1][j-1]==0){
                        rb[i][j]=rb[i-1][j-1]+1;
                        onerb[i][j]=onerb[i-1][j-1];
                    }else if(arr[i-1][j-1]==1){
                        rb[i][j]=2;
                        onerb[i][j]=onerb[i-1][j-1];
                    }
                }else{
                    ans=1;
                    onerb[i][j]=true;
                }
            }
        }

        int[][] lb=new int[n][m];
        boolean[][] onelb=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=m-1;j>=0;j--){
                lb[i][j]=1;
                if(i==0 || j==m-1){
                    if(arr[i][j]==1){
                        onelb[i][j]=true;
                    }
                    continue;
                }
                if(arr[i][j]==0){
                    if(arr[i-1][j+1]==2){
                        lb[i][j]=lb[i-1][j+1]+1;
                        onelb[i][j]=onelb[i-1][j+1];
                    }
                }else if(arr[i][j]==2){
                    if(arr[i-1][j+1]==0){
                        lb[i][j]=lb[i-1][j+1]+1;
                        onelb[i][j]=onelb[i-1][j+1];
                    }else if(arr[i-1][j+1]==1){
                        lb[i][j]=2;
                        onelb[i][j]=onelb[i-1][j+1];
                    }
                }else{
                    onelb[i][j]=true;
                }
            }
        }
        
        int[][] tl=new int[n][m];
        boolean[][] onetl=new boolean[n][m];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                tl[i][j]=1;
                if(i==n-1 || j==m-1){
                    if(arr[i][j]==1){
                        onetl[i][j]=true;
                    }
                    continue;
                }
                if(arr[i][j]==0){
                    if(arr[i+1][j+1]==2){
                        tl[i][j]=tl[i+1][j+1]+1;
                        onetl[i][j]=onetl[i+1][j+1];
                    }
                }else if(arr[i][j]==2){
                    if(arr[i+1][j+1]==0){
                        tl[i][j]=tl[i+1][j+1]+1;
                        onetl[i][j]=onetl[i+1][j+1];
                    }else if(arr[i+1][j+1]==1){
                        tl[i][j]=2;
                        onetl[i][j]=onetl[i+1][j+1];
                    }
                }else{
                    onetl[i][j]=true;
                }
            }
        }

        int[][] tr=new int[n][m];
        boolean[][] onetr=new boolean[n][m];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<m;j++){
                tr[i][j]=1;
                if(i==n-1 || j==0){
                    if(arr[i][j]==1){
                        onetr[i][j]=true;
                    }
                    continue;
                }
                if(arr[i][j]==0){
                    if(arr[i+1][j-1]==2){
                        tr[i][j]=tr[i+1][j-1]+1;
                        onetr[i][j]=onetr[i+1][j-1];
                    }
                }else if(arr[i][j]==2){
                    if(arr[i+1][j-1]==0){
                        tr[i][j]=tr[i+1][j-1]+1;
                        onetr[i][j]=onetr[i+1][j-1];
                    }else if(arr[i+1][j-1]==1){
                        tr[i][j]=2;
                        onetr[i][j]=onetr[i+1][j-1];
                    }
                }else{
                    onetr[i][j]=true;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int ex=1;
                if(onetr[i][j]){
                    if(onetr[i][j] && onetl[i][j])ex++;
                    ans=Math.max(ans,tr[i][j]+tl[i][j]-ex);
                }
                ex=1;
                if(onetl[i][j]){
                    if(onetl[i][j] && onelb[i][j])ex++;
                    ans=Math.max(ans,tl[i][j]+lb[i][j]-ex);
                }
                ex=1;
                if(onelb[i][j]){
                    if(onelb[i][j] && onerb[i][j])ex++;
                    ans=Math.max(ans,lb[i][j]+rb[i][j]-ex);
                }
                ex=1;
                if(onerb[i][j]){
                    if(onetr[i][j] && onerb[i][j])ex++;
                    ans=Math.max(ans,tr[i][j]+rb[i][j]-ex);
                  //  System.out.println(i+" "+j+" "+tr[i][j]+" "+rb[i][j]);
                }
        //  System.out.println(i+" "+j+" "+onetr[i][j]+" "+onetl[i][j]+" "+onelb[i][j]+" "+onerb[i][j]);
      //  System.out.println(i+" "+j+" "+ans);
            }
        }
        return ans;
    }
}
/*
    2,3
    3,2
*/
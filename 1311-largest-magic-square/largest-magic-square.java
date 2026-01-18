class Solution {
    public int largestMagicSquare(int[][] arr) {
        int max=1;
        int n=arr.length;
        int m=arr[0].length;
        int[][] ver=new int[n][m];
        int[][] hor=new int[n][m];

        for(int i=0;i<n;i++){
            hor[i][0]=arr[i][0];
            for(int j=1;j<m;j++){
                hor[i][j]=hor[i][j-1]+arr[i][j];
            }
        }
        for(int i=0;i<m;i++){
            ver[0][i]=arr[0][i];
            for(int j=1;j<n;j++){
                ver[j][i]=ver[j-1][i]+arr[j][i];
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.print(ver[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int k=i+1;
                int p=j+1;
                while(k<n && p<m){
                        int sum=hor[i][p]-((j==0)?0:hor[i][j-1]);
                        
                        boolean flag=false;
                        for(int t=i;t<=k && !flag;t++){
                            int curr=hor[t][p]-((j==0)?0:hor[t][j-1]);
                            if(sum!=curr){
                                flag=true;
                            }
                        }

                        for(int t=j;t<=p && !flag;t++){
                            int curr=ver[k][t]-((i==0)?0:ver[i-1][t]);
                            if(sum!=curr){
                                flag=true;
                            }
                        }

                        int left=j;
                        int right=p;
                        int suml=0;
                        int sumr=0;
                        for(int t=i;t<=k && !flag;t++){
                            suml+=arr[t][left++];
                            sumr+=arr[t][right--];
                        }
                        // System.out.println(suml+" "+sumr+" "+sum+" "+i+" "+j+" "+k+" "+p);
                        if(!flag && suml==sumr && sumr==sum){
                            max=Math.max(max,k-i+1);
                        }
                        k++;
                        p++;
                }
            }
        }
        return max;
    }
}
/*
[[4,2,4,9,8,4,10,4]
,[3,10,10,1,5,1,1,6]
,[1,2,2,8,1,6,4,1]
,[4,6,8,3,5,7,8,6]
,[6,7,3,4,9,2,10,9]
,[10,1,6,3,2,3,4,5]]
*/
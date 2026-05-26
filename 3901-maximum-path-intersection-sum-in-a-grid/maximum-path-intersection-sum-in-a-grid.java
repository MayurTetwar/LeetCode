class Solution {
    public int maxScore(int[][] arr) {
        int max=-(int)1e9;
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            if(i==0 || i==n-1){
                int sum=arr[i][0];
                for(int j=1;j<m-1;j++){
                    sum+=arr[i][j];
                    sum=Math.max(sum,arr[i][j]+arr[i][j-1]);
                    max=Math.max(max,sum);
                }
                max=Math.max(max,arr[i][m-1]+arr[i][m-2]);
                max=Math.max(max,sum+arr[i][m-1]);
            }else{
                int sum=arr[i][0];
                if(sum<0)sum=0;
                for(int j=1;j<m-1;j++){
                    sum+=arr[i][j];
                    if(sum<0){
                        sum=0;
                        if(j==m-2)sum=arr[i][j];
                    }
                    max=Math.max(max,sum);
                }
                max=Math.max(max,sum+arr[i][m-1]);
            }
        }
        // System.out.println(max);
        for(int i=0;i<m;i++){
            if(i==0 || i==m-1){
                int sum=arr[0][i];
                for(int j=1;j<n-1;j++){
                    sum+=arr[j][i];
                    sum=Math.max(sum,arr[j][i]+arr[j-1][i]);
                    max=Math.max(max,sum);
                }
                max=Math.max(max,arr[n-1][i]+arr[n-2][i]);
                max=Math.max(max,sum+arr[n-1][i]);
            }else{
                int sum=arr[0][i];
                if(sum<0)sum=0;
                for(int j=1;j<n-1;j++){
                    sum+=arr[j][i];
                    if(sum<0){
                        sum=0;
                        if(j==n-2)sum=arr[j][i];
                    }
                    max=Math.max(max,sum);
                }
                max=Math.max(max,sum+arr[n-1][i]);
            }
            // System.out.println(i+" "+max);
        }
        return max;
    }

    /*
    [[-13,2,-11,15]
    ,[-1,-14,3,-4]
    ,[6,-9,-12,-14]
    ,[1,20,-13,10]
    ,[-9,-6,-20,3]
    ,[20,-8,-17,-4]
    ,[7,12,12,-20]
    ,[13,-12,9,-11]
    ,[-18,1,5,4]
    ,[-6,16,1,11]]
    */
}
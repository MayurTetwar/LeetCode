class Solution {
    public boolean findRotation(int[][] arr, int[][] tar) {
        int n=arr.length;
        boolean flag=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]!=tar[i][j]){
                    flag=false;
                    break;
                }
            }
            if(!flag)break;
        }
        
        if(flag)return true;

        flag=true;
        int k=n-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[j][k]!=tar[i][j]){
                    flag=false;
                    break;
                }
            }
            k--;
            if(!flag)break;
        }
        // System.out.println(flag);

        if(flag)return true;

        flag=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[n-i-1][n-j-1]!=tar[i][j]){
                    flag=false;
                    break;
                }
            }
            if(!flag)break;
        }

        if(flag)return true;

        flag=true;
        for(int i=0;i<n;i++){
            k=n-1;
            for(int j=0;j<n;j++){
                if(arr[k][i]!=tar[i][j]){
                    flag=false;
                    break;
                }
                k--;
            }
            if(!flag)break;
        }
        // System.out.println(flag);
        return flag;
    }
}
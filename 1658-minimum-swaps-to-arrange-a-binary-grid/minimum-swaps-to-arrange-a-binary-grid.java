class Solution {
    public int minSwaps(int[][] arr) {
        int n=arr.length;
        int ans=0;
        int[] pos=new int[n];
        for(int i=0;i<n;i++){
            for(int j=n-1;j>=0;j--){
                if(arr[i][j]==1){
                    pos[i]=j;
                    break;
                }
            }
        }
        for(int i=0;i<n;i++){
            int idx=-1;
            for(int j=i;j<n;j++){
                if(pos[j]<=i){
                    ans+=j-i;
                    idx=j;
                    break;
                }
            }
            if(idx==-1)return -1;
            for(int j=idx;j>i;j--){
                pos[j]=pos[j-1];
            }
        }
        return ans;
    }
}
class Solution {
    public int minOperations(int[] arr) {
        int n=arr.length;
        int count=0;
        for(int i=0;i<n-2;i++){
            if(arr[i]==1)continue;
            count++;
            for(int j=0;j<3;j++){
                arr[i+j]=1-arr[i+j];
            }
        }
        if(arr[n-2]==0 || arr[n-1]==0)return -1;
        return count;
    }
}
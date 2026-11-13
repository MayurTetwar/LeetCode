class Solution {
    public boolean checkPossibility(int[] arr) {
        int n=arr.length;
        if(n==2)return true;
        boolean flag=false;
        int idx=-1;
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                if(flag){
                    return false;
                }
                flag=true;
                idx=i;
            }
        }
        if(!flag || idx==0 || idx+1==n-1)return true;
        return arr[idx-1]<=arr[idx+1] || arr[idx]<=arr[idx+2];
    }
}
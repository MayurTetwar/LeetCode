class Solution {
    public int longestMountain(int[] arr) {
        int ans=0;
        int i=0;
        int n=arr.length;
        while(i<n-1){
            int last=i;
            boolean flag=false;
            boolean flag2=false;
            while(i<n-1 && arr[i]<arr[i+1]){
                i++;
                flag=true;
            }
            while(i<n-1 && arr[i]>arr[i+1]){
                i++;
                flag2=true;
            }
            if(flag && flag2){
                ans=Math.max(ans,i-last+1);
            }
            while(i<n-1 && arr[i]==arr[i+1])i++;
        }
        //if(ans<3)return 0;
        return ans;
    }
}
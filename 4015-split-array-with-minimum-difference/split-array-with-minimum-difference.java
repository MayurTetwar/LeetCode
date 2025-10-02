class Solution {
    public long splitArray(int[] arr) {
        int n=arr.length;
        int ind=-1;
        long leftsum=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i-1]>=arr[i]){
                ind=i;
                break;
            }
            leftsum+=arr[i];
        }
        if(ind==-1){
            long ans1=Math.abs(leftsum-arr[0]*2);
            long ans2=Math.abs(leftsum-arr[n-1]*2);
            return Math.min(ans1,ans2);
        }
        long rightsum=arr[ind];
        for(int i=ind+1;i<n;i++){
            if(arr[i-1]<=arr[i]){
                return -1;
            }
            rightsum+=arr[i];
        }
        // System.out.println(leftsum+" "+rightsum);
        
        long ans1=Math.abs(leftsum-rightsum);
        if(ind>0 && arr[ind-1]!=arr[ind]){
            leftsum-=arr[ind-1];
            rightsum+=arr[ind-1];
        }
        long ans2=Math.abs(leftsum-rightsum);
        // System.out.println(leftsum+" "+rightsum);
        return Math.min(ans1,ans2);
    }
}
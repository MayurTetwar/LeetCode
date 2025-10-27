class Solution {
    public int maxPossibleScore(int[] arr, int d) {
        Arrays.sort(arr);
        int n=arr.length;
        int st=0;
        int end=arr[n-1]+d-arr[0];
        int ans=1000000000;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(helper(arr.clone(),d,mid)){
                st=mid+1;
            }else{
                end=mid-1;
            }
        //    System.out.println(ans+" "+st+" "+end);
        }
        return end;
    }
    public boolean helper(int[] arr,int d,int tar){
        int n=arr.length;
        long next=arr[0]+tar;
    //    if(next>arr[0]+d)return false;
        for(int i=1;i<n;i++){
            if(arr[i]+d<next)return false;
            next=Math.max(next,arr[i])+tar;
        }
        // System.out.println(tar+" "+next);
        return true;
    }
    // 4,10,14,15,19
    // 5,10,15,20,25
}
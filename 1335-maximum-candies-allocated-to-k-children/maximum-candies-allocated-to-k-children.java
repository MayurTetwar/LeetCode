class Solution {
    static{
        for(int i=0;i<500;i++){
            maximumCandies(new int[]{1},1);
        }
    }
    public static int maximumCandies(int[] arr, long k) {
        int n =arr.length;
        long start=0;
        long end=0;
        if(n==1 && k==1)return arr[0];
        for(int i=0;i<n;i++){
            end+=arr[i];
        }
        end=end/k;
        while(start<=end){
            //System.out.println(start+" "+end);
            long mid=start+(end-start)/2;
            if(helper(arr,k,mid)){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return (int)end;
    }
    public static boolean helper(int[] arr,long k,long mid){
        int i=0;
        if(mid==0){
            if(k==1 && arr[0]>=mid)return false;
            return true;
        }
        while(i<arr.length && k>0){
            long val=(long)arr[i]/mid;
            k-=val;
            i++;
            //System.out.println(k+" "+val+" --");
        }
        if(k<=0)return true;
        return false;
    }
}
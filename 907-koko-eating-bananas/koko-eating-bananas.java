class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        long start=1;
        long end=max;
        long ans=0;
        while (start<=end) {
            long mid=start+(end-start)/2;
            long count=isGood(arr,mid,h);
            if(count>h){
                start=mid+1;
            }else{
                end=mid-1;
                ans=mid;
            }
        }
        return (int)ans;
    }
    static long isGood(int[] arr,long mid,int h){
     
        long count=0;
        int i=0;
        boolean flag=true;
        int num=arr[0];
        while(i<arr.length){
            count+=(arr[i]/mid);
            if(arr[i]%mid!=0){
                count++;
            }
            i++;
        }
        //System.out.println(count+"---");
        return count;
    }
}
class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        int currx=0;
        int currn=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int n=arr.length;
        int total=0;
        for(int i=0;i<n;i++){
            total+=arr[i];
            currx+=arr[i];
            currn+=arr[i];
            if(max<currx){
                max=currx;
            }
            currx=Math.max(currx,0);
            if(min>currn){
                min=currn;
            }
            currn=Math.min(currn,0);
          //  System.out.println(curr+" "+max);
        }
        if(total==min)return max;
        return Math.max(max,total-min);
    }

}
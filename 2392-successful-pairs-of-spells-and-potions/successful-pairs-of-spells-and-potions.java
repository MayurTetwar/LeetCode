class Solution {
    public int[] successfulPairs(int[] sp, int[] pot, long max) {
        int n=sp.length;
        int m=pot.length;
        Arrays.sort(pot);
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int index = bs(pot,sp[i],max);
            // System.out.println(index);
            ans[i]=m-index;
        }
        return ans;
    }
    public int bs(int[] arr,long val,long max){
        int st=0;
        int end=arr.length;
        while(st<end){
            int mid=st+(end-st)/2;
            if(arr[mid]*val>=max)end=mid;
            else st=mid+1;
        }
        return st;
    }   
}
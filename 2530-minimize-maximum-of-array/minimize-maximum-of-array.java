class Solution {
    public int minimizeArrayValue(int[] arr) {
        int st=Integer.MAX_VALUE;
        int end=-1;
        for(int num:arr){
            st=Math.min(st,num);
            end=Math.max(end,num);
        }
        int ans=st;
        while(st<=end){
            int mid=st+(end-st)/2;
            boolean get=isValid(arr,mid);
          //  System.out.println(get+" "+mid);
            if(get){
                end=mid-1;
                ans=mid;
            }else{
                st=mid+1;
            }
        }
        return ans;
    }
    public boolean isValid(int[] arr,int val){
        long max=0;
        for(int num:arr){
            if(num<val){
                max+=val-num;
            }else{
                max-=(num-val);
                if(max<0)return false;
            }
        }
        return true;
    }
}
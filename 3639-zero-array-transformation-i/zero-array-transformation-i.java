class Solution {
    public boolean isZeroArray(int[] arr, int[][] que) {
        int n=arr.length;
        int[] ans=new int[n];
        for(int a[]:que){
            ans[a[0]]-=1;
            if((a[1]+1)<n){
                ans[a[1]+1]+=1;
            }
        }
        for(int i=1;i<n;i++){
            ans[i]+=ans[i-1];
        }
        //System.out.println(Arrays.toString(ans));
        for(int i=0;i<n;i++){
            //System.out.println(ans[i]+" "+arr[i]);
            if(ans[i]+arr[i]>0)return false;
        }
        return true;
    }
}
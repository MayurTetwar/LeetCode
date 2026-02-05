class Solution {
    public int[] constructTransformedArray(int[] arr) {
        int n=arr.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                int ind=(i+arr[i])%n;
                ans[i]=arr[ind];
            }else if(arr[i]<0){
                int ind=(i+arr[i])%n;
                if(ind<0)ind+=n;
                System.out.println(ind);
                ans[i]=arr[ind];
            }else{
                ans[i]=arr[i];
            }
        }
        return ans;
    }
}
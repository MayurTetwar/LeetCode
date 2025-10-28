class Solution {
    public int countValidSelections(int[] arr) {
        int ans=0;
        int n=arr.length;
        int[] left=new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0)left[i]=sum;  
            sum+=arr[i];
        }
        sum=0;
        for(int i=n-1;i>=0;i--){
            if(arr[i]==0){
                if(left[i]==sum)ans+=2;
                else if(left[i]==sum+1)ans++;
                else if(left[i]+1==sum)ans++;
            }
            sum+=arr[i];
        }

        return ans;
    }
}
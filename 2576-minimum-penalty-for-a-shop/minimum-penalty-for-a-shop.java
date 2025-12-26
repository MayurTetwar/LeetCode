class Solution {
    public int bestClosingTime(String s) {
        int n=s.length();
        int[] arr=new int[n];
        int count=0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='Y')count++;
            arr[i]=count;
        }
        int ans=0;
        int min=arr[0];
        count=0;
        for(int i=0;i<n;i++){
            int curr=0;
            if(i>0)curr+=count;
            if(i<n-1)curr+=arr[i+1];
            if(curr<min){
                min=curr;
                ans=i+1;
            }
            if(s.charAt(i)=='N')count++;
        }
        return ans;
    }
}
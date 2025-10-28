class Solution {
    public int minSumOfLengths(int[] arr, int tar) {
        int n=arr.length;
        int[] left=new int[n];
        int[] right=new int[n];
        Arrays.fill(left,1000000000);
        Arrays.fill(right,1000000000);

        int i=0;
        int j=0;
        int curr=0;
        while(j<n){
            curr+=arr[j];
            while(i<=j && curr>tar){
                curr-=arr[i];
                i++;
            }
            if(curr==tar){
                if(j<n-1)left[j+1]=j-i+1;
                if(i>0)right[i-1]=j-i+1;
            }
            j++;
        }

        int min=left[0];
        for(i=0;i<n;i++){
            min=Math.min(left[i],min);
            left[i]=min;
        }
        min=right[n-1];
        for(i=n-1;i>=0;i--){
            min=Math.min(right[i],min);
            right[i]=min;
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        int ans=Integer.MAX_VALUE;
        for(i=1;i<n;i++){
            ans=Math.min(ans,left[i]+right[i-1]);
        }
        return (ans>=1000000000)?-1:ans;
    }
}
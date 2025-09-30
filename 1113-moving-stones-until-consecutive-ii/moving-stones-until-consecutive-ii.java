class Solution {
    public int[] numMovesStonesII(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        int max=Math.max(arr[1]-arr[0]-1,arr[n-1]-arr[n-2]-1);
        for(int i=1;i<n-2;i++){
            max+=(arr[i+1]-arr[i]-1);   
        }
        int min=n;
        int j=0;
        for(int i=0;i<n;i++){
           while(arr[i]-arr[j]>=n)j++;
           if(i-j+1==n-1 && arr[i]-arr[j]==n-2)min=Math.min(min,2);
           else min=Math.min(min,n-(i-j+1));
        }
        return new int[]{min,max};
    }
}
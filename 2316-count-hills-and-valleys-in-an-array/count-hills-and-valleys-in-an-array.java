class Solution {
    public int countHillValley(int[] arr) {
        int ans=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            while(i<n-1 && arr[i]==arr[i+1])i++;
            int left=i-1;
            int right=i+1;
            while(left>=0 && arr[left]==arr[i])left--;
            while(right<n && arr[right]==arr[i])right++;
           // System.out.println(left+" "+right);
            if(left<0 || right>=n)continue;
            if((arr[left]>arr[i] && arr[i]<arr[right])||(arr[left]<arr[i] && arr[i]>arr[right])){
                ans++;
            }
        }
        return ans;
    }
}
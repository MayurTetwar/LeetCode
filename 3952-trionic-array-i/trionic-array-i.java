class Solution {
    public boolean isTrionic(int[] arr) {
        int n=arr.length;
        if(arr[0]>=arr[1])return false;
        int i=0;
        while(i<n-1 && arr[i]<arr[i+1])i++;
        if(i==n-1 || arr[i]==arr[i+1])return false;
        while(i<n-1 && arr[i]>arr[i+1])i++;
        if(i==n-1 || arr[i]==arr[i+1])return false;
        while(i<n-1 && arr[i]<arr[i+1])i++;
        if(i<n-1)return false;
        return true;
    }
}
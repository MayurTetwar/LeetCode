class Solution {
    public int findPairs(int[] arr, int k) {
        Arrays.sort(arr);
        int n=arr.length;
        int i=0,j=1;
        int count=0;
        // 1 1 3 4 5
        while(j<n){
            while(j<n-1 && arr[j]==arr[j+1])j++;
            if(i<j && arr[j]-arr[i]==k){
                count++;
                j++;
            }else if(arr[j]-arr[i]<k){
                j++;
            }else{
                i++;
                if(i==j)j++;
            }
        }
        return count;
    }
}
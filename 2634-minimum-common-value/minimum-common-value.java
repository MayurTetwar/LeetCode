class Solution {
    public int getCommon(int[] arr1, int[] arr2) {
        int i=0;
        int j=0;
        int n=arr1.length;
        int m=arr2.length;
        while(i<n && j<m){
            if(arr1[i]==arr2[j]){
                return arr1[i];
            }else if(arr1[i]<arr2[j]){
                i++;
            }else{
                j++;
            }
        }
        return -1;
    }
}
class Solution {
    public int[] findThePrefixCommonArray(int[]  arr1,int[] arr2) {
        int n=arr1.length;
        int[] count1=new int[n+1];
        int[] count2=new int[n+1];
        int[] res=new int[n];
        int ans=0;
        for(int i=0;i<n;i++){
            count1[arr1[i]]++;
            count2[arr2[i]]++;

            if(count1[arr1[i]]+count2[arr1[i]]==2){
                ans++;
            }
            if(count1[arr2[i]]+count2[arr2[i]]==2){
                ans++;
            }
            if(arr1[i]==arr2[i])ans--;
            res[i]=ans;
        }
        return res;
    }
}
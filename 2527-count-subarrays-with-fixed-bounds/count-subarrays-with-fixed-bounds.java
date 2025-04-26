class Solution {
    public long countSubarrays(int[] arr, int minK, int maxK) { 
        long ans=0;
        int minInd=-1;
        int max=-1;
        int min=10000000;
        int maxInd=-1;
        int n=arr.length;
        int st=-1;
        for(int i=0;i<n;i++){
            if(minK>arr[i] || maxK<arr[i]){
                st=i;
                max=-1;
                min=10000000;
                continue;
            }
            if(max<=arr[i]){
                max=arr[i];
                maxInd=i;
            }
            if(min>=arr[i]){
                min=arr[i];
                minInd=i;
            }
            if(minK==min && max==maxK){
                if(maxInd>=st && minInd>=st){
           //System.out.println(minInd+" "+maxInd);
                    ans+=(Math.min(maxInd,minInd)-st);
                }
            }
        }
        return ans;
    }
}
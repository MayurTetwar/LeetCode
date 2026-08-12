class Solution {
    public int maxNumOfMarkedIndices(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        int j=0;
        int[] count=new int[n];
        int ans=0;
        // System.out.println(Arrays.toString(arr));
        for(int i=0;i<n && j<n;i++){
            while(j<n && arr[i]*2>arr[j])j++;
            if(j<n){
                count[i]++;
                count[j]++;
                j++;
            }
            // System.out.println(i+" "+j);
        }
        for(int i=1;i<n;i++){
            count[i]+=count[i-1];
        }
        if(n%2==1)return Math.min(n-1,count[n-1]);
        return Math.min(n,count[n-1]);
    }
}
class Solution {
    public long maxRatings(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        if(m==1){
            long ans=0;
            for(int i=0;i<n;i++)ans+=arr[i][0];
            return ans;
        }
        for(int i=0;i<n;i++){
            Arrays.sort(arr[i]);
        }
        long ans=0;
        int min=(int)1e9;
        int min2=(int)1e9;
        for(int i=0;i<n;i++){
            min=Math.min(min,arr[i][0]);
            min2=Math.min(min2,arr[i][1]);
            ans+=arr[i][1];
            // System.out.println(min+" "+min2);
        }
        return ans-min2+min;
    }
}
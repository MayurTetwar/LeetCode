class Solution {
    public int countTrapezoids(int[][] arr) {
        long ans=0;
        int mod=1000000007;
        Arrays.sort(arr,(a,b)->{
            if(a[1]!=b[1])return a[1]-b[1];
            return a[0]-b[0];
        });
        int n=arr.length;
        long[] same=new long[n];
       // for(int i=0;i<n;i++)
       // //  System.out.println(Arrays.toString(arr[i]));
        
        for(int i=n-2;i>=0;i--){
            int j=i+1;
            while(i>=0 && arr[i][1]==arr[j][1]){
                same[i]=same[i+1];
                i--;
            }
            long dis=j-i;
            // // System.out.println(dis);
            if(i>=0)same[i]=(((same[i]+same[i+1])%mod)+((dis*(dis-1)/2)%mod))%mod;
        }
        // System.out.println(Arrays.toString(same));
        int j=1;
        while(j<n && arr[j][1]!=arr[j-1][1])j++;
        int i=j-1;
        while(j<n){
            while(j+1<n && arr[j][1]==arr[j+1][1])j++;
            if(j==n-1)break;
            // System.out.println(i+" "+j+" "+same[j]);
            if(arr[i][1]==arr[j][1]){
                long value=((long)(j-i)*(j-i+1))%mod;
                ans=(ans+(value*same[j]/2)%mod)%mod;
            }
            j++;
            i=j;
        }
        return (int)(ans%mod);
    }
}
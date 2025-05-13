class Solution {
    public int lengthAfterTransformations(String s, int t) {
        long[] arr=new long[26];
        for(char ch:s.toCharArray()){
            arr[ch-'a']++;
        }
        long mod = 1000000007;
        long first=arr[0];
        while(t-->0){
            for(int i=1;i<26;i++){
                long temp=arr[i];
                arr[i]=first;
                first=temp;
            }
            arr[1]=(arr[1]+first)%mod;
            arr[0]=first;
            // for(int i=0;i<26;i++){
            //     System.out.print(arr[i]+" ");
            // }
            // System.out.println();
        }
        
        long ans=0;
        for(int i=0;i<26;i++){
            ans=(ans+arr[i])%mod;
        }
        return (int)ans;
    }
    /*
        bcdzz -> 0 1 1 1 ... 2
        ababcde -> 
    */
}
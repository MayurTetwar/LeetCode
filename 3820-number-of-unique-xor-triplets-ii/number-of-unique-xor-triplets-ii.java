class Solution {
    public int uniqueXorTriplets(int[] arr) {
    
        boolean[] visi=new boolean[2048];
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                visi[arr[i]^arr[j]]=true;
            }
        }
        boolean[] set=new boolean[2048];
        int len=0;
        for(int i=0;i<2028;i++){
            if(!visi[i])continue;
            for(int j=0;j<n;j++){
                if(!set[i^arr[j]])len++;
                set[i^arr[j]]=true;
            }
        }
        return len;
    }
}
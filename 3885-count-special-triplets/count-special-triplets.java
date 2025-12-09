class Solution {
    public int specialTriplets(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        long mod=1000000007;
        int n=arr.length;
        long[] left=new long[n];
        int i=0;
        for(int num:arr){
            if(map.containsKey(num*2)){
                left[i]=map.get(num*2);
            }
            map.put(num,map.getOrDefault(num,0)+1);
            i++;
        }
        long[] right=new long[n];
        map=new HashMap<>();
        for(i=n-1;i>=0;i--){
            int num=arr[i];
            if(map.containsKey(num*2)){
                right[i]=map.get(num*2);
            }
            map.put(num,map.getOrDefault(num,0)+1);
        }
        long ans=0;
        for(i=0;i<n;i++){
          //  System.out.println(left[i]+" "+right[i]);
            ans=(ans+left[i]*right[i])%mod;
        }
        return (int)ans;
    }
}
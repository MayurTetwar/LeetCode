class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        int n=arr.length;
        map.put(0,1);
        for(int i=0;i<n;i++){
            if(i>0)arr[i]+=arr[i-1];
            int val=arr[i]%k;
            if(val<0){
                val+=k;
            }
            ans+=map.getOrDefault(val,0);
            map.put(val%k,map.getOrDefault(val%k,0)+1);
           // System.out.println(map);
        }
        return ans;
    }
}
class Solution {
    public long[] distance(int[] arr) {
        HashMap<Integer,long[]> map=new HashMap<>();
        int n=arr.length;
        long[] ans=new long[n];
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                long[] fs=map.get(arr[i]);
                ans[i]+=(i+1)*fs[0]-fs[1];
                fs[1]+=(i+1);
                fs[0]++;
                map.put(arr[i],fs);
            }else{
                map.put(arr[i],new long[]{1,i+1});
            }
        } 
        map=new HashMap<>();
        for(int i=n-1;i>=0;i--){
            if(map.containsKey(arr[i])){
                long[] fs=map.get(arr[i]);
                ans[i]+=(n-i)*fs[0]-fs[1];
                fs[1]+=(n-i);
                fs[0]++;
                map.put(arr[i],fs);
            }else{
                map.put(arr[i],new long[]{1,n-i});
            }
        } 
        return ans;
    }
}
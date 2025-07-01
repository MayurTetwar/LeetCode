class Solution {
    public int oddEvenJumps(int[] arr) {
        int n=arr.length;
        if(n<=1)return 1;
        boolean[] odd=new boolean[n];
        boolean[] even=new boolean[n];
        TreeMap<Integer,Integer> map=new TreeMap<>();
        odd[n-1]=even[n-1]=true;
        map.put(arr[n-1],n-1);
        for(int i=n-2;i>=0;i--){
            Integer higher=map.ceilingKey(arr[i]);
            Integer smaller=map.floorKey(arr[i]);
            if(higher!=null){
                odd[i] = even[map.get(higher)];
            }
            if(smaller!=null){
                even[i]=odd[map.get(smaller)];
            }
            map.put(arr[i],i);
        }
        int ans=0;
        for(boolean b:odd){
            if(b)ans++;
        }
        return ans;
    }
}
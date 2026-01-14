class Solution {
    public long taskSchedulerII(int[] arr, int sp) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        long[] save=new long[n];
        long curr=0;
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                long len=i-map.get(arr[i])-1;
                long done=curr-save[map.get(arr[i])];
                if(len+done<sp){
                    curr+=sp-(len+done);
                }
            }
            save[i]=curr;
            map.put(arr[i],i);
        }
        return n+curr;
    }
}
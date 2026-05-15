class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] arr, int id, int vd) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int n=arr.length;
        for(int i=0;i<id;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(int i=0;i<n;i++){
            System.out.println(i);
            map.put(arr[i],map.get(arr[i])-1);
            if(map.get(arr[i])==0)map.remove(arr[i]);
            if(i+id<n)map.put(arr[i+id],map.getOrDefault(arr[i+id],0)+1);
            int lowerval=arr[i]-vd;
            Integer next=map.ceilingKey(lowerval);
            if(next!=null && next<=arr[i]+vd){
                // System.out.println(next+" "+i);
                return true;
            }
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            if(i-id>=0){
                map.put(arr[i-id],map.get(arr[i-id])-1);
                if(map.get(arr[i-id])==0)map.remove(arr[i-id]);
            }
        }
        return false;
    }
}
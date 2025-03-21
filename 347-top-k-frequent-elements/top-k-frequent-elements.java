class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> map.get(b)-map.get(a));
        for(Integer num:map.keySet()){
            pq.add(num);
        }
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.poll();
        }
        return ans;
    }
}
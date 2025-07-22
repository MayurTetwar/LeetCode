class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        int n=arr.length;
        int[] ans=new int[n-k+1];
        for(int i=0;i<k;i++){
            pq.add(arr[i]);
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        ans[0]=pq.peek();
        int idx=1;
        for(int i=k;i<n;i++){
            pq.add(arr[i]);
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            map.put(arr[i-k],map.get(arr[i-k])-1);
            if(map.get(arr[i-k])==0){
                map.remove(arr[i-k]);
            }
            while(!map.containsKey(pq.peek())){
                pq.poll();
            }
            ans[idx++]=pq.peek();
        }
        return ans;
    }
}
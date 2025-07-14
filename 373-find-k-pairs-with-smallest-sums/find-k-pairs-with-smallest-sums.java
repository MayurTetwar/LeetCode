class Solution {
    public List<List<Integer>> kSmallestPairs(int[] arr1, int[] arr2, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b) -> a[0] - b[0]);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<arr1.length;i++){
            pq.add(new int[]{arr1[i]+arr2[0],0});
        }
        while(k>0){
            int[] curr=pq.poll();
            list.add(Arrays.asList(curr[0]-arr2[curr[1]],arr2[curr[1]]));
            if(curr[1]+1<arr2.length){
                pq.add(new int[]{curr[0]-arr2[curr[1]]+arr2[curr[1]+1],curr[1]+1});
            }
            k--;
        }
        return list;
    }
}
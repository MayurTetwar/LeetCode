class Solution {
    public List<List<Integer>> getSkyline(int[][] arr) {
        int n=arr.length;
        List<List<Integer>> ans=new ArrayList<>();
        List<int[]> map=new ArrayList<>();
        for(int[] r:arr){
            map.add(new int[]{r[0],-r[2]});
            map.add(new int[]{r[1],r[2]});
        }
        Collections.sort(map,(a,b)->{
            if(a[0]!=b[0])return a[0]-b[0];
            return a[1]-b[1];
        });
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        pq.add(0);
        int prev=0;
        for(int[] h:map){
            if(h[1]<0){
                pq.add(-h[1]);
            }else{
                pq.remove(h[1]);
            }
            int curr=pq.peek();
            if(prev!=curr){
                List<Integer> list=new ArrayList<>();
                list.add(h[0]);
                list.add(curr);
                ans.add(list);
            }
            prev=curr;
        }
        return ans;
    }
}
class Solution {
    public int scheduleCourse(int[][] arr) {
        Arrays.sort(arr,(a,b)->{
            return a[1]-b[1];
        });
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return b-a;
        });
        int max=0;
        for(int[] a:arr){
            max+=a[0];
            pq.add(a[0]);
            if(max>a[1])max-=pq.poll();
        }
        return pq.size();
    }
}
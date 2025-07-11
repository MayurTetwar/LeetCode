class Solution {
    public int mostBooked(int n, int[][] arr) {
        int m=arr.length;
     //   if(n>m)return 0;
        int[] count=new int[n];
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[1]!=b[1]){
                return a[1]-b[1];
            }
            return a[2]-b[2];
        });
        PriorityQueue<Integer> pqr=new PriorityQueue<>();
        for(int i=0;i<n;i++)pqr.add(i);
        for(int i=0;i<m;i++){
            while(pq.size()>0 && pq.peek()[1]<=arr[i][0]){
                pqr.add(pq.poll()[2]);
            }
            if(pqr.size()==0){
                int[] fin=pq.poll();
                count[fin[2]]++;
                pq.add(new int[]{fin[1],arr[i][1]+fin[1]-arr[i][0],fin[2]});
            }else{
                int roomNo=pqr.poll();
                count[roomNo]++;
                pq.add(new int[]{arr[i][0],arr[i][1],roomNo});
            }
           // System.out.println(pqr);
        }
        int max=0;
        int roomNo=-1;
        for(int i=0;i<n;i++){
            if(max<count[i]){
                roomNo=i;
                max=count[i];
            }
            //System.out.println(count[i]);
        }
        return roomNo;
    }
}
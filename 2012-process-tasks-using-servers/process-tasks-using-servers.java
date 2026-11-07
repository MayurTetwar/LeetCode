class Solution {
    public int[] assignTasks(int[] ser, int[] task) {
        int n=ser.length;
        int m=task.length;
        int[] ans=new int[m];
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->{
            return a[0]-b[0];
        });
        PriorityQueue<Integer> pq=new PriorityQueue((x,y)->{
            int a=(int)x;
            int b=(int)y;
            if(ser[a]!=ser[b])return ser[a]-ser[b];
            return a-b;
        });
        for(int i=0;i<n;i++){
            pq.add(i);
        }
        int ts=0;
        for(int i=0;i<m;i++){
            // System.out.println(pq);
            ts=Math.max(ts,i);
            while(!q.isEmpty() && ts>=q.peek()[0]){
                pq.add(q.poll()[1]);
            }
            if(pq.isEmpty()){
                ts=q.peek()[0];
                while(!q.isEmpty() && ts>=q.peek()[0]){
                    pq.add(q.poll()[1]);
                }
            }
            int idx=pq.poll();
            ans[i]=idx;
            q.add(new int[]{ts+task[i],idx});
        }
        return ans;
    }
}
class Solution {
    public int maximumRobots(int[] ch, int[] run, long budget) {
        long curr=0;
        int n=run.length;
        int right=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->ch[b]-ch[a]);
        int ans=0;
        for(int left=0;left<n && right<n;){
            while(right<n){
                int max=(pq.isEmpty())?0:ch[pq.peek()];
                max=Math.max(max,ch[right]);
                // max(chargeTimes) + k * sum(runningCosts)
                long val=max+(right-left+1)*(curr+run[right]);
                //  System.out.println(val+" "+max+" "+right);
                if(val>budget){
                    break;
                }
                pq.add(right);
                curr+=run[right];
                right++;
            }
            //  System.out.println(ans+" "+left+" "+right+" "+pq);
            ans=Math.max(ans,right-left);
            if(left<right)curr-=run[left];
            if(!pq.isEmpty() && pq.peek()==left){
                pq.poll();
                while(!pq.isEmpty() && pq.peek()<left)pq.poll();
            }
            left++;
            right=Math.max(right,left);
        }
        return ans;
    }
    /*
    
    */
}
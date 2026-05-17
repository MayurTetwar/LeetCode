class Solution {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        Queue<Integer> q=new LinkedList<>();
        boolean[] visi=new boolean[n];
        q.add(start);
        visi[start]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            if(arr[curr]==0)return true;
            if((curr-arr[curr])>=0 && !visi[curr-arr[curr]]){
                q.add(curr-arr[curr]);
                visi[curr-arr[curr]]=true;
            }
            if((curr+arr[curr])<n && !visi[curr+arr[curr]]){
                q.add(curr+arr[curr]);
                visi[curr+arr[curr]]=true;
            }
        }
        return false;
    }
}
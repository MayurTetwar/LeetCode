class Solution {
    public int closestMeetingNode(int[] arr, int node1, int node2) {
        int n=arr.length;
        int[] dist1=new int[n];
        int[] dist2=new int[n];
        Arrays.fill(dist1,-1);
        Arrays.fill(dist2,-1);
        helper(arr,node1,dist1,0);
        helper(arr,node2,dist2,0);
        int max=n+1;
        int ans=-1;
        for(int i=0;i<n;i++){
            if(max>Math.max(dist1[i],dist2[i]) && dist1[i]!=-1 && dist2[i]!=-1){
                max=Math.max(dist1[i],dist2[i]);
                ans=i;
            }
        }
        return ans;
    }
    public void helper(int[] arr,int node,int[] dist,int d){
        if(node==-1 || dist[node]!=-1)return;
        dist[node]=d;
        helper(arr,arr[node],dist,d+1);
    }
    /*

       

    */
}
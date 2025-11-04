class Solution {
    public int[] findXSum(int[] arr, int k, int x) {
        int n=arr.length;

        int[] ans=new int[n-k+1];
        for(int i=0;i<=n-k;i++){
            int[] cnt=new int[51];
            for(int j=i;j<i+k;j++){
                cnt[arr[j]]++;
            }
            PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
                if(cnt[a]!=cnt[b])return cnt[b]-cnt[a];
                return b-a;
            });
            for(int j=0;j<51;j++){
                if(cnt[j]>0)pq.add(j);
            }
          //  System.out.println(pq);
            int sum=0;
            for(int j=0;j<x && pq.size()>0;j++){
                int ind=pq.poll();
                ans[i]+=ind*cnt[ind];
            }
        }
        return ans;
    }
}
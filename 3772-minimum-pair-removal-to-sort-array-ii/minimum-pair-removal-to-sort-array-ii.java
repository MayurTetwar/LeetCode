class Solution {
    public int minimumPairRemoval(int[] ar) {
        int n=ar.length;
        if(n<=1)return 0;

        long[] arr=new long[n];
        int[] prev=new int[n];
        int[] next=new int[n];
        boolean[] invalid=new boolean[n];

        for(int i=0;i<n;i++)arr[i]=ar[i];

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) ->{
            if(a[0]!=b[0]){
                return Long.compare(a[0], b[0]);
            }
            return Long.compare(a[1], b[1]);
        });
        int rev=0;
        for(int i=0;i<n;i++){
            if(i<n-1){
                pq.add(new long[]{arr[i]+arr[i+1],i});
                if(arr[i]>arr[i+1])rev++;
            }
            prev[i]=i-1;
            next[i]=i+1;
        }

        int ans=0;
        while(rev>0){
            long[] curr=pq.poll();
            if(curr==null)break;
            int left=(int)curr[1];
            int right=next[left];
            if(right>=n || invalid[left] || invalid[right] || arr[left]+arr[right]!=curr[0]){
                continue;
            }
            
            int pre=prev[left];
            int nxt=next[right];

// System.out.println(rev+"-1");
            if(arr[left]>arr[right])rev--;
            if(pre!=-1 && arr[pre]>arr[left])rev--;
            if (nxt != n && arr[right]>arr[nxt]) rev--;

            // System.out.println(rev+"-2");
            arr[left]+=arr[right];
            invalid[right]=true;

            if (pre != -1) {
                pq.add(new long[]{arr[pre] + arr[left], pre});
                if (arr[pre] > arr[left]) rev++;
            } else {
                prev[left] = -1;
            }

            if (nxt != n) {
                prev[nxt] = left;
                next[left] = nxt;
                pq.add(new long[]{arr[left] + arr[nxt], left});
                if (arr[left] > arr[nxt]) rev++;
            } else {
                next[left] = n;
            }
            ans++;
            // System.out.println(Arrays.toString(arr)+" "+rev);
            // for(int i=0;i<n;i++){
            //     if(invalid[i])continue;
            //     System.out.print(arr[i]+" ");
            // }
            // System.out.println();
        }
        return ans;
    }
}
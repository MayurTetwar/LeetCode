class Solution {
    public long minimumDifference(int[] arr) {
        int n=arr.length;
        PriorityQueue<Integer> pqr=new PriorityQueue<>(Comparator.reverseOrder());
        int parts=n/3;
        long pre[]=new long[n];
        long sumA=0;
        for(int i=0;i<parts;i++){
            pqr.add(arr[i]);
            sumA+=arr[i];
            pre[i]=sumA;
        }
        for(int i=parts;i<2*parts;i++){
            if(sumA>sumA-pqr.peek()+arr[i]){
                sumA=sumA-pqr.poll()+arr[i];
                pqr.add(arr[i]);
            }
            pre[i]=sumA;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        long suff[]=new long[n];
        long sumB=0;
        for(int i=n-1;i>=2*parts;i--){
            pq.add(arr[i]);
            sumB+=arr[i];
            suff[i]=sumB;
        }
        for(int i=2*parts-1;i>=parts;i--){
            if(sumB<sumB-pq.peek()+arr[i]){
                sumB=sumB-pq.poll()+arr[i];
                pq.add(arr[i]);
            }
            suff[i]=sumB;
        }
        // System.out.println(Arrays.toString(pre));
        // System.out.println(Arrays.toString(suff));
        long ans=Long.MAX_VALUE;
        for(int i=parts-1;i<2*parts;i++){
            ans=Math.min(ans,pre[i]-suff[i+1]);
        }
        return ans;
    }
}
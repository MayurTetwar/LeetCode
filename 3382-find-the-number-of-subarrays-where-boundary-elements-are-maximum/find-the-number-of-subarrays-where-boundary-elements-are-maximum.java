class Solution {
    public long numberOfSubarrays(int[] arr) {
        long ans=0;
        int n=arr.length;
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]>b[0])return 1;
            return -1;
        });

        for(int i=0;i<n;i++){
           // if(pq.size()>0)System.out.println(i+" "+pq.peek()[0]+" "+arr[i]);
            while(pq.size()>0 && pq.peek()[0]<arr[i]){
                pq.poll();
            }
            if(pq.size()>0 && pq.peek()[0]==arr[i]){
                long max[]=pq.poll();
                ans+=max[1];
                max[1]++;
                pq.add(max);
            }else{
                pq.add(new long[]{(long)arr[i],1L});
            }
        }
        // long ans=0;
        // int max=-1;
        // int n=arr.length;
        // Map<Integer,Long> map=new HashMap<>();
        // for(int i=0;i<n;i++){
        //     if(max<arr[i]){
        //         map=new HashMap<>();
        //         max=arr[i];
        //         map.put(arr[i],1L);
        //     }else{
        //         if(map.containsKey(arr[i])){
        //             long val=map.get(arr[i]);
        //             ans+=val;
        //             if(arr[i]==max)map=new HashMap<>();
        //             map.put(arr[i],val);
        //         }
                
        //         map.put(arr[i],map.getOrDefault(arr[i],0L)+1L);
        //     }
        //     System.out.println(map+" "+i+" "+ans);
        // }
        return ans+n;
    }
}
class Solution {
    public long minimumDifference(int[] arr) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            if(a>b)return -1;
            return 1;
        });
        int n=arr.length;
        long[] pre=new long[n];
        long min=0;
        for(int i=0;i<n/3;i++){
            pq.add(arr[i]);
            min+=arr[i];
            pre[i]=min;
        }
        for(int i=n/3;i<2*n/3;i++){
            if(min-pq.peek()+arr[i]<min){
                min=min-pq.poll()+arr[i];
                pq.add(arr[i]);
            }
            ////System.out.println(min);
            pre[i]=min;
        }
      //  ////System.out.println(min+" "+Arrays.toString(visi));
        pq=new PriorityQueue<>((a,b)->{
            if(a>b)return 1;
            return -1;
        });
        long[] suff=new long[n];
        long max=0;
        for(int i=n-1;i>=n*2/3;i--){
            pq.add(arr[i]);
            max+=arr[i];
            suff[i]=max;
        }
        for(int i=(n*2/3)-1;i>=n/3;i--){
            if(max-pq.peek()+arr[i]>max){
                max=max-pq.poll()+arr[i];
                pq.add(arr[i]);
            }
            suff[i]=max;
        }
        //System.out.println(Arrays.toString(pre));
        //System.out.println(Arrays.toString(suff));
        long ans=Long.MAX_VALUE;
        for(int i=n/3-1;i<(n*2/3);i++){
            //System.out.println(pre[i]+" "+suff[i]);
            ans=Math.min(ans,pre[i]-suff[i+1]);
        }
        return ans;
    }
}
/*
class Solution {
    public long minimumDifference(int[] arr) {
        int n=arr.length;
       
        return helper(arr,0,0L,n/3,0L,n/3,n/3);
    }
    public long helper(int[] arr,int i,long sumA,int a,long sumB,int b,int c){
        if(a==0 && b==0 && c==0){
            //////System.out.println(sumA+" "+sumB);
            return sumA-sumB;
        }
        if(i>=arr.length)return Long.MAX_VALUE;
        long ans=Long.MAX_VALUE;
        if(a>0){
            ans=Math.min(ans,helper(arr,i+1,sumA+arr[i],a-1,sumB,b,c));
        }
        if(b>0){
            ans=Math.min(ans,helper(arr,i+1,sumA,a,sumB+arr[i],b-1,c));
        }
        if(c>0)
            ans=Math.min(ans,helper(arr,i+1,sumA,a,sumB,b,c-1));
        return ans;
    }
}
*/
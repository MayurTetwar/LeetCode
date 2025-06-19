class Solution {
    public long numberOfSubarrays(int[] arr) {
        long ans=0;
        int n=arr.length;
        Stack<long[]> stk=new Stack<>();

        for(int i=0;i<n;i++){
            while(stk.size()>0 && stk.peek()[0]<arr[i]){
                stk.pop();
            }
            if(stk.size()>0 && stk.peek()[0]==arr[i]){
                long max[]=stk.pop();
                ans+=max[1];
                max[1]++;
                stk.push(max);
            }else{
                stk.push(new long[]{(long)arr[i],1L});
            }
        }
        return ans+n;
    }
}
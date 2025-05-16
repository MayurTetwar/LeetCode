class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod=1000000007;
        int n=arr.length;
        int[] right=new int[n];
        Stack<Integer> stk=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(stk.size()>0 && arr[stk.peek()]>=arr[i]){
                stk.pop();
            }
            if(stk.size()==0)right[i]=n;
            else right[i]=stk.peek();
            stk.push(i);
        }
        int[] left=new int[n];
        stk=new Stack<>();
        for(int i=0;i<n;i++){
            while(stk.size()>0 && arr[stk.peek()]>arr[i]){
                stk.pop();
            }
            if(stk.size()==0)left[i]=-1;
            else left[i]=stk.peek();
            stk.push(i);
        }
        long ans=0;
        for(int i=0;i<n;i++){
            ans=(ans+(long)(i-left[i])*(right[i]-i)*arr[i])%mod;
        }
        return (int)ans;
    }
}
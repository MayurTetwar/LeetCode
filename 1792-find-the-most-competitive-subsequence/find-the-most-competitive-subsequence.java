class Solution {
    public int[] mostCompetitive(int[] arr, int k) {
        int n=arr.length;
        int j=0;
        int[] ans=new int[k];
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<n;i++){
            while(stk.size()>0 && arr[stk.peek()]>arr[i] && n-i+stk.size()>k){
                stk.pop();
            }
            stk.push(i);
        }
        for(int i=0;i<k;i++){
            ans[i]=arr[stk.get(i)];
        }
        return ans;
    }
}
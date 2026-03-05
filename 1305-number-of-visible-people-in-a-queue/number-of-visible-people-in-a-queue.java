class Solution {
    public int[] canSeePersonsCount(int[] arr) {
        int n=arr.length;
        int[] ans=new int[n];
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && arr[stk.peek()]<arr[i]){
                ans[stk.pop()]++;
            }
            if(!stk.isEmpty()){
                ans[stk.peek()]++;
            }
            stk.add(i);
        }
        return ans;
    }
}
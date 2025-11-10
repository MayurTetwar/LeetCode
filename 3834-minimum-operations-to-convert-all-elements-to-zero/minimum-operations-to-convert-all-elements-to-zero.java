class Solution {
    public int minOperations(int[] arr) {
        int n=arr.length;
        Stack<Integer> stk=new Stack<>();
        int ans=0;
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && stk.peek()>=arr[i]){
                if(stk.peek()>arr[i])ans++;
                stk.pop();
            }
            if(arr[i]>0)stk.push(arr[i]);
        }
        return stk.size()+ans;
    }
}
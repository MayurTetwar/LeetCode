class Solution {
    public int largestRectangleArea(int[] arr) {
        int n=arr.length;
        int[] left=new int[n];
        int[] right=new int[n];
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && arr[stk.peek()]>=arr[i]){
                stk.pop();
            }
            if(stk.size()>0)left[i]=stk.peek();
            else left[i]=-1;
            stk.push(i);
        }
        stk=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && arr[stk.peek()]>=arr[i]){
                stk.pop();
            }
            if(stk.size()>0)right[i]=stk.peek();
            else right[i]=n;
            stk.push(i);
        }
       // System.out.println(Arrays.toString(left)+"\n"+Arrays.toString(right));
        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,(right[i]-left[i]-1)*arr[i]);
        }
        return ans;
    }
}
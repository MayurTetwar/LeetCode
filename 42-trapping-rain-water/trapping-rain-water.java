class Solution {
    public int trap(int[] arr) {
        Stack<Integer> stk=new Stack<>();
        int ans=0;
        int max=arr[0];
        for(int i=0;i<arr.length;i++){
            while(!stk.isEmpty() && max<=arr[i]){
                int left=stk.pop();
                ans+=(Math.min(arr[i],max)-arr[left]);
            }
            max=Math.max(max,arr[i]);
            stk.add(i);
           // System.out.println(ans+" "+stk);
        }
        int rightmax=arr[arr.length-1];
        while(!stk.isEmpty()){
            int right=stk.pop();
            if(Math.min(rightmax,max)-arr[right]>0){
                ans+=Math.min(rightmax,max)-arr[right];
            }
            rightmax=Math.max(rightmax,arr[right]);
        }
        return ans;
    }
}
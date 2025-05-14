class Solution {
    public int minOperations(int[] arr) {
        Stack<Integer> stk=new Stack<>();
        int ans=0;
        int n=arr.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set=new HashSet<>();
            if(arr[i]==0){
                while(stk.size()>0){
                    if(!set.contains(arr[stk.peek()])){
                        ans++;
                        // System.out.println(i);
                        set.add(arr[stk.peek()]);
                    }
                    // set.remove(arr[stk.pop()]);
                    stk.pop();
                } 
                continue;
            }
            while(stk.size()>0 && arr[stk.peek()]>arr[i]){
                if(!set.contains(arr[stk.peek()])){
                    ans++;
                    // System.out.println(i);
                    set.add(arr[stk.peek()]);
                }
                // set.remove(arr[stk.pop()]);
                stk.pop();
            } 
            stk.push(i);
            // System.out.println(stk);
        }
        while(stk.size()>0){
            if(!set.contains(arr[stk.peek()])){
                ans++;
                set.add(arr[stk.peek()]);
            }
            stk.pop();
        } 
        return ans;
    }
}
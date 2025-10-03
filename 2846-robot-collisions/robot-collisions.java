class Solution {
    public List<Integer> survivedRobotsHealths(int[] arr, int[] hel,String s) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->arr[a]-arr[b]);
        int n=arr.length;
        for(int i=0;i<n;i++){
            pq.add(i);
        }
        List<Integer> list=new ArrayList<>();
        Stack<Integer> stk=new Stack<>();
        while(!pq.isEmpty()){
            int curr=pq.poll();
            if(s.charAt(curr)=='R'){
                stk.add(curr);
            }else{
                while(!stk.isEmpty() && hel[stk.peek()]<hel[curr]){
                    stk.pop();
                    hel[curr]--;
                }
                if(stk.isEmpty())list.add(curr);
                else if(hel[stk.peek()]==hel[curr])stk.pop();
                else hel[stk.peek()]--;
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!stk.isEmpty()){
            list.add(stk.pop());
        }
        Collections.sort(list);
        for(int ind:list){
            ans.add(hel[ind]);
        }
        return ans;
    }
}
class Solution {
    int n;
    int[] arr;
    public int minAbsDifference(int[] arr, int goal) {
        this.n=arr.length;
        this.arr=arr;
        List<Integer> pos=new ArrayList<>();
        List<Integer> neg=new ArrayList<>();
        helper(pos,0,0,n/2);
        helper(neg,n/2,0,n);
        Collections.sort(pos);
        Collections.sort(neg);
        // System.out.println(pos);
        // System.out.println(neg);
        int ans=Integer.MAX_VALUE;
        int i=0;
        int j=neg.size()-1;
        while(i<pos.size() && j>=0){
            int sum=pos.get(i)+neg.get(j);
            ans=Math.min(ans,Math.abs(sum-goal));
            if(sum<goal){
                i++;
            }else if(sum>goal){
                j--;
            }else{
                return 0;
            }
        }
        return ans;
    }
    public void helper(List<Integer> list,int i,int sum,int limit){
        if(i==limit){
            list.add(sum);
            return;
        }
        helper(list,i+1,sum,limit);
        helper(list,i+1,sum+arr[i],limit);
    }
}
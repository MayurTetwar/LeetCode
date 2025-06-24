class Solution {
    public int minAbsoluteDifference(List<Integer> list, int x) {
        int ans=Integer.MAX_VALUE;
        TreeSet<Integer> ts = new TreeSet<>();    
        int n=list.size();    
        for(int i=0;i<n;i++){
            if(x<=i){
                ts.add(list.get(i-x));
                ans=Math.min(ans,findNear(ts,list.get(i)));
            }
        } 
        return ans;
    }
    public int findNear(TreeSet<Integer> ts,int x){
        if(ts.contains(x))return 0;
        Integer low=ts.lower(x);
        Integer high=ts.higher(x);
        if (low == null) return high.intValue()-x;
        if (high == null) return x-low.intValue();
        int val1=x - low.intValue();
        int val2=high.intValue() - x;
        return Math.min(val1,val2);

    }
}
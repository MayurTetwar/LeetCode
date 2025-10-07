class Solution {
    public int[] avoidFlood(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        int[] ans=new int[n];
        Arrays.fill(ans,1);
        TreeSet<Integer> ts=new TreeSet<>();
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                ans[i]=-1;
                if(map.containsKey(arr[i])){
                    Integer ind=ts.higher(map.get(arr[i]));
                    if(ind==null){
                        return new int[]{};
                    }
                    ans[ind]=arr[i];
                    ts.remove(ind);
                }
                map.put(arr[i],i);
            }else{
                ts.add(i);
            }
            // System.out.println(map+" "+ts+" "+i);
        }
        return ans;
    }
}
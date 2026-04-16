class Solution {
    public List<Integer> solveQueries(int[] arr, int[] que) {
        int n=arr.length;
        int[] ans=new int[n];
        Arrays.fill(ans,n);
        HashMap<Integer,Integer> map=new HashMap<>();
        HashMap<Integer,Integer> first=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!first.containsKey(arr[i])){
                first.put(arr[i],i);
            }
            if(map.containsKey(arr[i])){
                int idx=map.get(arr[i]);    
                // System.out.println(i+" "+first.get(arr[i]));
                ans[i]=Math.min(ans[i],Math.min(i-idx,n+first.get(arr[i])-i));
                ans[idx]=Math.min(ans[idx],Math.min(i-idx,n+first.get(arr[i])-idx));
            }
            map.put(arr[i],i);
        }
        List<Integer> res=new ArrayList<>();
        for(int q:que){
            if(ans[q]==n)res.add(-1);
            else{
                int last=map.get(arr[q]);
                res.add(Math.min(ans[q],n-last+q));
            }
        }
        return res;
    }
}
class Solution {
    int fullmask;
    List<Integer> max;
    List<Integer>[][] dp;
    public int[] smallestSufficientTeam(String[] arr, List<List<String>> list) {
        HashMap<String,Integer> map=new HashMap<>();
        int n=arr.length;
        fullmask=0;
        max=new ArrayList<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],i);
            fullmask=fullmask|(1<<i);
            max.add(i);
        }
        dp=new ArrayList[fullmask][list.size()];
        List<Integer> ansl=helper(0,map,0,list);
        // int[] ans=new int[Integer.bitCount(ansmask)];
        // int ind=0;
        // for(int i=0;i<32;i++){
        //     if((ansmask&(1<<i))!=0){
        //         ans[ind++]=i;
        //     }
        // }
        int[] ans=new int[ansl.size()];
        for(int i=0;i<ans.length;i++){
            ans[i]=ansl.get(i);
        }
        return ans;
    }
    public List<Integer> helper(int mask,HashMap<String,Integer> map,int i,List<List<String>> list){
        if(mask==fullmask){
            return new ArrayList<>();
        }
        if(i==list.size()){
            return max;
        }
       if(dp[mask][i]!=null)return dp[mask][i];
        List<Integer> res1=helper(mask,map,i+1,list);
        boolean valid=false;
        int newmask=0;
        for(String s:list.get(i)){
            if((mask&(1<<map.get(s)))==0){
                valid=true;
            }
            newmask=newmask|(1<<map.get(s));
        }
        List<Integer> res2=max;
        if(valid){
            // System.out.println(valid+" "+i);
            res2=helper(newmask|mask,map,i+1,list);
            res2=new ArrayList<>(res2);
            res2.add(i);
        }
        if(res1.size()<res2.size()){
            return dp[mask][i]=res1;
        }
        return dp[mask][i]=res2;
    }
}
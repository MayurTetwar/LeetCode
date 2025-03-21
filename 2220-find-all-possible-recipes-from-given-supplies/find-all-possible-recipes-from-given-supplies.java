class Solution {
    public List<String> findAllRecipes(String[] arr, List<List<String>> list, String[] sup) {
        HashSet<String> set=new HashSet<>();
        for(String str:sup){
            set.add(str);
        }
        int count=0;
        int n=arr.length;
        List<String> ans=new ArrayList<>();
        boolean[] visi=new boolean[n];
        int save=-1;
        int k=0;
        int all=0;
        while(k<n && all<10000){
            if(save==count)break;
            if(!visi[count]){
                List<String> res=list.get(count);
                int i=0;
                for(i=0;i<res.size();i++){
                    if(!set.contains(res.get(i)))break;
                }
                if(i==res.size()){
                    visi[count]=true;
                    ans.add(arr[count]);
                    set.add(arr[count]);
                    k++;
                    save=count;
                }
            }
            count++;
            count=count%n;
            all++;
        }
        return ans;
    }
}
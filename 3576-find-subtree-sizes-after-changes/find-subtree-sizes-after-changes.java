class Solution {
    public int[] findSubtreeSizes(int[] par, String s) {
        int n=par.length;
        int[] dis=new int[n];
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++)list.add(new ArrayList<>());
        for(int i=1;i<n;i++){
            list.get(par[i]).add(i);
        }
        int[] papa=new int[26];
        Arrays.fill(papa,-1);
        helper(list,papa,s,0,-1,dis);
        return dis;
    }
    public void helper(List<List<Integer>> list,int[] papa,String s,int i,int originalpapa,int[] dis){
        int temp=papa[s.charAt(i)-'a'];
        papa[s.charAt(i)-'a']=i;
        for(int next:list.get(i)){
            helper(list,papa,s,next,i,dis);
        }
        papa[s.charAt(i)-'a']=temp;
        dis[i]++;
        if(papa[s.charAt(i)-'a']!=-1){
            int newpapa=papa[s.charAt(i)-'a'];
            dis[newpapa]+=dis[i];
        }else if(originalpapa!=-1){
            dis[originalpapa]+=dis[i];
        }
    }
}
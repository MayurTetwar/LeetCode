class Solution {
    int[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        memo=new int[s.length()];
        Arrays.fill(memo,-1);
        return helper(s,0,wordDict);
    }
    public boolean helper(String s,int i,List<String> list){
        if(i==s.length())return true;
        if(memo[i]!=-1)return (memo[i]==1)?true:false;
        for(int j=0;j<list.size();j++){
            int size=list.get(j).length();
        //    if(i+size<=s.length()) System.out.println(list.get(j)+" "+(s.substring(i,i+size)));
            if(i+size<=s.length() && list.get(j).equals(s.substring(i,i+size))){
                if(helper(s,i+size,list)){
                    memo[i]=1;
                    return true;
                }
            }
        }
        memo[i]=0;
        return false;
    }
}
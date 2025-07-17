class Solution {
    int ninf=Integer.MIN_VALUE;
    int[][] memo;
    public int lengthOfLongestSubsequence(List<Integer> list, int target) {
        memo=new int[list.size()][target+1];
        for(int i=0;i<list.size();i++){
            Arrays.fill(memo[i],-1);
        }
        int len=helper(list,0,target);
        return (len<=0)?-1:len;
    }
    public int helper(List<Integer> list,int i,int tar){
        if(tar==0)return 0;
        if(list.size()==i)return ninf;
        if(memo[i][tar]!=-1)return memo[i][tar];
        int len1=helper(list,i+1,tar);
        int len2=ninf;
        if(tar>=list.get(i)){
            len2=1+helper(list,i+1,tar-list.get(i));
        }
        return memo[i][tar]=Math.max(len1,len2);
    }
}
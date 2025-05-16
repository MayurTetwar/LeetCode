class Solution {
    public List<String> getWordsInLongestSubsequence(String[] word, int[] arr) {
        int n=arr.length;
        int[] dp=new int[n];
        int[] prev=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(prev,-1);
        int maxIndex=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(isSame(word[i],word[j]) && dp[i]<dp[j]+1 && arr[i]!=arr[j]){
                    dp[i]=dp[j]+1;
                    prev[i]=j;
                }
            }
            if(dp[i]>dp[maxIndex]){
                maxIndex=i;
            }
        }
        List<String> list=new ArrayList<>();
        for(int i=maxIndex;i!=-1;i=prev[i]){
            list.add(word[i]);
        }
        Collections.reverse(list);
        return list;
    }
    public boolean isSame(String str,String str2){
        int count=0;
        if(str.length()!=str2.length())return false;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=str2.charAt(i)){
                count++;
            }
            if(count>1)return false;
        }
        return count==1;
    }
}
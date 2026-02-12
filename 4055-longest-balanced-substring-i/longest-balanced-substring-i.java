class Solution {
    public int longestBalanced(String s) {
        int max=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            int[] count=new int[26];
            if(max>n-i+1)break;
            for(int j=i;j<n;j++){
                count[s.charAt(j)-'a']++;
                int last=0;
                boolean flag=true;
                for(int ch=0;ch<26;ch++){
                    if(count[ch]==0)continue;
                    if(last==0){
                        last=count[ch];
                    }else if(last!=count[ch]){
                        flag=false;
                    }
                }
                if(flag)max=Math.max(max,j-i+1);
            }
        }
        return max;
    }
}
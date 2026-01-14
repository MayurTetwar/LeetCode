class Solution {
    public int minCharacters(String a, String b) {
        int[] count1=new int[26];
        int[] count2=new int[26];
        for(char ch:a.toCharArray()){
            count1[ch-'a']++;
        }
        for(char ch:b.toCharArray()){
            count2[ch-'a']++;
        }

        int n=a.length();
        int m=b.length();
        int res=n+m;

        for(int i=0;i<=25;i++){
            res=Math.min(res,n-count1[i]+m-count2[i]);
            // System.out.println(i+" "+res);
            if(i>0){
                count1[i]+=count1[i-1];
                count2[i]+=count2[i-1];
            }
            if(i<25){
                res=Math.min(res,n-count1[i]+count2[i]);
                res=Math.min(res,m-count2[i]+count1[i]);
            }
        }
        return res;
    }
}
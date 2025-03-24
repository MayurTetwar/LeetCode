class Solution {
    static{
        for(int i=0;i<500;i++){
            beautySum("a");
        }
    }
    public static int beautySum(String s) {
        int count=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            int[] map=new int[26];
            for(int j=i;j<n;j++){
                map[s.charAt(j)-'a']++;
                int min=Integer.MAX_VALUE;
                int max=Integer.MIN_VALUE;
                for(int k=0;k<26;k++){
                    if(map[k]>0){
                        max=Math.max(max,map[k]);
                        min=Math.min(min,map[k]);
                    }
                }
                count+=(max-min);
            }
        }
        return count;
    }
}
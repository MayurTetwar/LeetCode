class Solution {
    public int uniqueLetterString(String s) {
        int n=s.length();
        int[] next=new int[n];
        int[] prev=new int[n];
        int[] ch=new int[26];
        Arrays.fill(ch,n);
        for(int i=n-1;i>=0;i--){
            int c=s.charAt(i)-'A';
            next[i]=ch[c];
            ch[c]=i;
        }
        ch=new int[26];
       Arrays.fill(ch,-1);
        for(int i=0;i<n;i++){
            int c=s.charAt(i)-'A';
            prev[i]=ch[c];
            ch[c]=i;
        }
        // System.out.println(Arrays.toString(prev));
        // System.out.println(Arrays.toString(next));
        int ans=0;
        for(int i=0;i<n;i++){
            int pr=prev[i];
            int ne=next[i];
            ans+=(ne-i)*(i-pr);
        }
        return ans;
    }
}
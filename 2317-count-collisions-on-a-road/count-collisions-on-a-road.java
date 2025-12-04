class Solution {
    public int countCollisions(String s) {
        char[] ch=s.toCharArray();
        int n=ch.length;
        int ans=0;
        for(int i=0;i<n-1;i++){
            if(ch[i]=='R' && ch[i+1]=='L'){
                ch[i]='S';
                ch[i+1]='S';
                ans+=2;
            }
        }
        // System.out.println(ans);
        int st=0;
        while(st<n && ch[st]=='L')st++;
        int end=n-1;
        while(end>=0 && ch[end]=='R')end--;
        for(int i=st;i<=end;i++){
            if(ch[i]=='L' || ch[i]=='R')ans++;
        }
        return ans;
    }
}
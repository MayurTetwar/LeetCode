class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n=s.length();
        int right=minJump;
        boolean[] visi=new boolean[n];
        visi[0]=true;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1')continue;
            int end=Math.min(n-1,i+maxJump);
            right=Math.max(right,i+minJump);
            while(right<=end){
                if(s.charAt(right)=='0')visi[right]=visi[right]|visi[i];
                right++;
            }
            right--;
        }
        return visi[n-1];
    }
}
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
            // System.out.println(i+" "+visi[i]+" "+end+" "+right);
            while(right<=end){
                // if(i==9){
                //     System.out.println(right+" "+(right==n-1)+" "+visi[i]);
                // }
                if(s.charAt(right)=='0')visi[right]=visi[right]|visi[i];
                // if(i==9){
                    // System.out.println(Arrays.toString(visi));
                // }
                right++;
            }
            right--;
            if(visi[n-1])return true;
        }
        // System.out.println(Arrays.toString(visi));
        return false;
    }
}
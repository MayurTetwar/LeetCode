class Solution {
    public long largestSquareArea(int[][] bl, int[][] tr) {
        long ans=0;
        int n=bl.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)continue;
                if(bl[j][0]>=tr[i][0] || bl[j][1]>=tr[i][1])continue;
                if(bl[i][0]>=tr[j][0] || bl[i][1]>=tr[j][1])continue;
                int trx=Math.min(tr[i][0],tr[j][0]);
                int try_=Math.min(tr[i][1],tr[j][1]);
                int blx=Math.max(bl[i][0],bl[j][0]);
                int bly=Math.max(bl[i][1],bl[j][1]);
                // if(trx-blx!=try_-bly)continue;
                // System.out.println(trx+" "+try_+" "+blx+" "+bly);
                ans=Math.max(ans,Math.min(trx-blx,try_-bly));
            }
        }
        return ans*ans;
    }
}
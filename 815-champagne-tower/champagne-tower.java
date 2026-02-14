class Solution {
    public double champagneTower(int po, int i, int j) {
        double[] prev=new double[Math.max(i,j)+1];
        if(po==0)return 0;

        int level=1;
        prev[0]=po;
        while(level<=i){
            double[] curr=new double[Math.max(i,j)+1];
            for(int k=0;k<level;k++){
                if(prev[k]<=1)continue;
                double overflow=(prev[k]-1)/2;
                curr[k]+=overflow;
                curr[k+1]+=overflow;
            }
            // System.out.println(Arrays.toString(curr));
            prev=curr;
            level++;
        }
        return Math.min(1,prev[j]);
    }
}
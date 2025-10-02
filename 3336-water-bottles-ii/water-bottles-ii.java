class Solution {
    public int maxBottlesDrunk(int numBottles, int ex) {
        int curr=numBottles;
        int empty=0;
        int ans=0;
        while(curr>0){
            ans+=curr;
            empty+=curr;
            int full=0;
            while((empty-ex)>=0){
                empty-=ex;
                full++;
                ex++;
            }
            curr=full;
            // System.out.println(curr);
        }
        return ans;
    }
}
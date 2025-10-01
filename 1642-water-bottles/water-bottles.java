class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans=0;
        int empty=0;
        while(numBottles>0){
            ans+=numBottles;
            int full=(numBottles+empty)/numExchange;
            empty=(numBottles+empty)-(numExchange*full);
            numBottles=full;
        }
        return ans;
    }
}
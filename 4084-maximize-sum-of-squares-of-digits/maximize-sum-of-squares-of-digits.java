class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<num;i++){
            int curr=9;
            while(curr>0 && sum-curr<0)curr--;
            sb.append(curr);
            sum-=curr;
        }
        if(sum>0)return "";
        return sb.toString();
    }
}
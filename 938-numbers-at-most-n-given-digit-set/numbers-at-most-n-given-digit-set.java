class Solution {
    int[] arr;
    String num;
    Integer[][][] memo;
    public int atMostNGivenDigitSet(String[] digits, int n) {
        arr=new int[digits.length];
        for(int i=0;i<digits.length;i++){
            arr[i]=Integer.parseInt(digits[i]);
        }
        num=String.valueOf(n);
        memo=new Integer[num.length()][2][2];
        return helper(0,1,0);
    }
    public int helper(int pos,int tight,int started){
        // System.out.println(pos+" "+tight);
        if(pos==num.length())return (started==1)?1:0;
        if(memo[pos][tight][started]!=null)return memo[pos][tight][started];
        int limit=(tight==1)?num.charAt(pos)-'0':arr[arr.length-1];
        int ans=0;
        if(started==0){
            ans+=helper(pos+1,0,0);
        }
        for(int i=0;i<arr.length;i++){ 
            if(arr[i]>limit)break;
            int newtight=(tight==1 && arr[i]==limit)?1:0;           
            ans+=helper(pos+1,newtight,1);
        }
        return memo[pos][tight][started]=ans;
    }   
}
/*
*/
class Solution {
    boolean st=true;
    boolean[] prime;
    public void find(){
        prime[0]=true;
        prime[1]=true;
        for(int i=2;i<33;i++){
            if(!prime[i]){
                for(int j=i*i;j<33;j+=i){
                    prime[j]=true;
                }
            }
        }
    }
    public int countPrimeSetBits(int left, int right) {
        if(st){
            prime=new boolean[33];
            st=false;
            find();
        }
        int count=0;
        for(int i=left;i<=right;i++){
            int set=Integer.bitCount(i);
            if(!prime[set]){
                count++;
            }
        }
        return count;
    }
}
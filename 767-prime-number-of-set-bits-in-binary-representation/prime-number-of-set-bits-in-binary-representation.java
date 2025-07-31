class Solution {
    boolean st=true;
    boolean[] prime;
    int[] arr;
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
    public void find2(){
        for(int i=1;i<=1000000;i++){
            int count=Integer.bitCount(i);
            if(!prime[count]){
                arr[i]++;
            }
            arr[i]+=arr[i-1];
        }
    }
    public int countPrimeSetBits(int left, int right) {
        if(st){
            prime=new boolean[33];
            find();
            arr=new int[1000001];
            find2();
            st=false;
        }
        return arr[right]-arr[left-1];
    }
}
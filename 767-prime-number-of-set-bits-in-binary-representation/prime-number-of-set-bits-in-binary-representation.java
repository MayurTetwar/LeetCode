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
        int[] arr=new int[right+1];
        for(int i=1;i<=right;i++){
            int count=Integer.bitCount(i);
            if(!prime[count]){
                arr[i]++;
            }
            arr[i]+=arr[i-1];
     //       System.out.println(count+" "+arr[i]);
        }
        return arr[right]-arr[left-1];
    }
}
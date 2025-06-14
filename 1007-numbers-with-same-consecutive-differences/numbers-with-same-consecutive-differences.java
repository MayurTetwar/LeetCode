class Solution {
    List<Integer> list;
    public int[] numsSameConsecDiff(int n, int k) {
        list=new ArrayList<>();
        for(int j=1;j<10;j++){
            helper(n-1,k,j,j);
        }
        int[] arr=new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
    public void helper(int n,int k,int last,int num){
        if(n==0){
            list.add(num);
            return;
        }
        if(last+k==last-k)helper(n-1,k,last+k,num*10+last+k);
        else{
            if(last+k<=9)helper(n-1,k,last+k,num*10+last+k);
            if(last-k>=0)helper(n-1,k,last-k,num*10+last-k);
        }
    }
}
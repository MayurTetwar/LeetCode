class Solution {
    HashMap<String,Integer> memo;
    public int makeArrayIncreasing(int[] arr, int[] arr2) {
        Arrays.sort(arr2);
       // System.out.println(Arrays.toString(arr2));
        int n=arr.length;
        memo=new HashMap<>();
        int ans=helper(arr,arr2,0,-1);
        return (ans==5000)?-1:ans;
    }
    public int helper(int[] arr,int[] arr2,int i,int prev){
        if(i==arr.length){
            return 0;
        }
        String s=String.valueOf(i).concat(" ").concat(String.valueOf(prev));
        if(memo.containsKey(s)){
            return memo.get(s);
        }
        int val=5000;
        if(arr[i]>prev){
            val=helper(arr,arr2,i+1,arr[i]);
        }
        int ind=findNear(prev,arr2);
        if(ind<arr2.length){
            val=Math.min(val,1+helper(arr,arr2,i+1,arr2[ind]));
        }
        memo.put(s,val);
        return val;
    }
    public int findNear(int num,int[] arr){
        int st=0;
        int end=arr.length;
        while(st<end){
            int mid=(st+end)/2;
            if(arr[mid]>num){
                end=mid;
            }else{
                st=mid+1;
            }
        }
        return st;
    }
}
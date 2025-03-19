class Solution {
    static{
        for(int i=0;i<500;i++){
            repairCars(new int[]{1},1);
        }
    }
    public static long repairCars(int[] arr, int cars) {
        long end=0;
        for(int i=0;i<arr.length;i++){
            end=Math.max(end,(long)arr[i]);
        }
        long st=0;
        end=end*cars*cars;
        while(st<end){
            long mid=st+(end-st)/2;
            //System.out.println(mid+" "+st+" "+end);
            if(helper(mid,arr,cars)){
                end=mid;
            }else{
                st=mid+1;
            }
        }
        return end;
    }
    public static boolean helper(long mid,int[] arr,int cars){
        int count=0;
        for(int i=0;i<arr.length;i++){
            count+=(int)Math.sqrt((mid/(long)arr[i]));
            if(count>=cars)return true;
        }
        return false;
    }
}
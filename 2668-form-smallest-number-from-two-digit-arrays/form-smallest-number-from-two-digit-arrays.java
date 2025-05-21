class Solution {
    public int minNumber(int[] arr, int[] arr2) {
        int n=arr.length;
        int m=arr2.length;
        boolean[] set=new boolean[10];
        boolean[] set2=new boolean[10];

        for(int num:arr){
            set[num]=true;
        }
        for(int num:arr2){
            set2[num]=true;
        }

        for(int i=1;i<=9;i++){
            if(set[i] && set2[i]){
                return i;
            }
        }
        int min=10;
        int min2=10;
        for(int num:arr){
            min=Math.min(num,min);
        }
        for(int num:arr2){
            min2=Math.min(num,min2);
        }
        return Math.min(min*10+min2,min2*10+min);
    }
}
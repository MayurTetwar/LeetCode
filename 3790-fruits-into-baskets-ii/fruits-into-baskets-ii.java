class Solution {
    public int numOfUnplacedFruits(int[] arr, int[] arr2) {
        int n=arr.length;
        int count=n;
        for(int i=0;i<n;i++){
            int num=arr[i];
            for(int j=0;j<n;j++){
                if(num<=arr2[j]){
                    arr2[j]=0;
                    count--;
                    break;
                }
            }
        }
        //System.out.println(count);
        return count;
    }
}
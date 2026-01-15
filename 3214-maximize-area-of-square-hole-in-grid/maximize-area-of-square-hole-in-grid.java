class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] arr1, int[] arr2) {
        int len1=arr1.length;
        int len2=arr2.length;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i=0;
        int max1=1;
        while(i<len1){
            int j=i;
            while(i+1<len1 && arr1[i]+1==arr1[i+1])i++;
            max1=Math.max(i-j+2,max1);
            i++;
        }
        i=0;
        int max2=1;
        while(i<len2){
            int j=i;
            while(i+1<len2 && arr2[i]+1==arr2[i+1])i++;
            max2=Math.max(i-j+2,max2);
            i++;
        }
        // System.out.println(max1+" "+max2);
        return Math.min(max1,max2)*Math.min(max1,max2);
    }
}
class Solution {
    public int[][] sortMatrix(int[][] arr) {
        int n=arr.length;
        for(int i=0;i<n;i++){
            List<Integer> list=new ArrayList<>();
            int j=i,k=0;
            while(j<n && k<n){
                list.add(arr[j][k]);
                j++;
                k++;
            }
            Collections.sort(list,Collections.reverseOrder());
            j=i;
            k=0;
            for(int num:list){
                arr[j][k]=num;
                j++;
                k++;
            }
        }
        for(int i=1;i<n;i++){
            List<Integer> list=new ArrayList<>();
            int j=0,k=i;
            while(j<n && k<n){
                list.add(arr[j][k]);
                j++;
                k++;
            }
            Collections.sort(list);
            j=0;
            k=i;
            for(int num:list){
                arr[j][k]=num;
                j++;
                k++;
            }
        }
        return arr;
    }
}
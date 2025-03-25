class Solution {
    public boolean checkValidCuts(int n, int[][] arr) {
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        int end=0;
        int count=0;
        int m=arr.length;
        for(int i=1;i<m;i++){
            if(arr[end][3]<=arr[i][1]){
                count++;
               // System.out.println(count+" 1");
                if(count>=2)return true;
            }
            end=(arr[end][3]>arr[i][3])?end:i;
        }
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        end=0;
        count=0;
        for(int i=1;i<m;i++){
            if(arr[end][2]<=arr[i][0]){
                count++;
                //System.out.println(count+" 2");
                if(count>=2)return true;
            }
            end=(arr[end][2]>arr[i][2])?end:i;
        }
        return false;
    }
}
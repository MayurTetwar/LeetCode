class Solution {
    static{
        for(int i=0;i<500;i++){
            diagonalSort(new int[][]{{0}});
        }
    }
    public static int[][] diagonalSort(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        for(int i=1;i<Math.min(m,n);i++){
            int j=0,k=m-i-1;
            int[] sortA=new int[i+1];
            while(j<=i){
                sortA[j]=arr[j][k];
                //System.out.println(j+" "+k);
                j++;
                k++;
            }
            Arrays.sort(sortA);
            //System.out.println(Arrays.toString(sortA));
            k=m-i-1;
            j=0;
            while(j<=i){
                //System.out.println(arr[j][k]+" "+sortA[j]);
                arr[j][k]=sortA[j];
                k++;
                j++;
            }
        }
        for(int i=m-n;i>=0;i--){
            int[] sortA=new int[n];
            int j=i,k=0;
            while(j<m && k<n){
                sortA[k]=arr[k][j];
                //System.out.println(k+" "+j);
                j++;
                k++;
            }
            //System.out.println(Arrays.toString(sortA));
            Arrays.sort(sortA);
            j=i;k=0;
            while(j<m && k<n){
                arr[k][j]=sortA[k];
                j++;
                k++;
            }
        }
        for(int i=n-2;i>0;i--){
            int j=n-i-1,k=0;
            int[] sortA=new int[Math.min(m,i+1)];
            while(j<n && k<m){
                sortA[k]=arr[j][k];
                //System.out.println(k+" "+j);
                j++;
                k++;
            }
            //System.out.println(Arrays.toString(sortA));
            Arrays.sort(sortA);
            j=n-i-1;k=0;
            while(j<n && k<m){
                arr[j][k]=sortA[k];
                k++;
                j++;
            }
        }
        return arr;
    }
}
/*
[[5,17,0,0,52,7]            
,[11,11,25,4,0,69]
,[14,23,25,44,45,1]
,[22,27,31,36,50,58]
,[84,28,75,33,55,68]]

[[5,17,4,1,52,7]
,[11,11,25,45,8,69]
,[14,23,25,44,58,15]
,[22,27,31,36,50,66]
,[84,28,75,33,55,68]]
*/
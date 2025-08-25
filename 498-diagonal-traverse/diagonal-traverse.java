class Solution {
    public int[] findDiagonalOrder(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        int[] ans=new int[n*m];
        for(int i=2;i<m;i+=2){
            int j=-1,bot=-1;
            if(i>n-1){
                j=i-(n-1);
                bot=n-1;
            }else{
                bot=i;
                j=0;
            }
            int k=i;
            int top=0;
            while(top<bot){
                int temp=arr[top][k];
                arr[top][k]=arr[bot][j];
                arr[bot][j]=temp;
                top++;
                k--;
                bot--;
                j++;
            }
        }
        for(int i=(m%2==0)?1:2;i<n;i+=2){
            int j=-1,bot=-1;
            if(i+m>n){
                j=m+i-n;
                bot=n-1;
            }else{
                bot=i+m-1;
                j=0;
            }
            int k=m-1;
            int top=i;
          //  System.out.println(k+" k "+j+" j "+top+" "+bot);
            while(top<bot){
                int temp=arr[top][k];
                arr[top][k]=arr[bot][j];
                arr[bot][j]=temp;
                top++;
                k--;
                bot--;
                j++;
            }
        }
        //   for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         System.out.print(arr[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int ind=0;
        for(int i=0;i<m;i++){
            int k=i,top=0;
            while(k>=0 && top<n){
                ans[ind++]=arr[top][k];
                top++;
                k--;
            }
        }
      
        for(int i=1;i<n;i++){
            int k=m-1,top=i;
            while(k>=0 && top<n){
                ans[ind++]=arr[top][k];
                top++;
                k--;
            }
        }
        return ans;
    }
}
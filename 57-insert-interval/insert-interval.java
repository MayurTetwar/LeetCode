class Solution {
    public int[][] insert(int[][] arr, int[] inter) {
        int start=-1;
        int end=-1;
        int n=arr.length;
        if(n==0)return new int[][]{inter};
        for(int i=0;i<n;i++){
            if(arr[i][0]<=inter[0] && inter[0]<=arr[i][1]){
                start=i;
            }
            if(arr[i][0]<=inter[1] && inter[1]<=arr[i][1]){
                end=i;
            }
        }
        if(start!=-1 && end!=-1){
            int[][] ans=new int[n-end+start][2];
            int i=0;
            while(i<start){
                ans[i][0]=arr[i][0];
                ans[i][1]=arr[i][1];
                i++;
            }
            ans[i][0]=arr[start++][0];
            ans[i][1]=arr[end][1];
            i=end+1;
            while(i<n){
                ans[start][0]=arr[i][0];
                ans[start++][1]=arr[i][1];
                i++;
            }
            return ans;
        }else if(start==-1 && end==-1){
            if(inter[0]<arr[0][0] && inter[1]>arr[n-1][1])return new int[][]{inter};
            int[][] ans=new int[10001][2];
            int i=0;
            int count=0;
            while(i<n && arr[i][0]<inter[0]){
                ans[i]=arr[i];
                i++;
                count++;
            }
            int save=i;
            while(i<n && arr[i][1]<inter[1])i++;
            ans[count][0]=inter[0];
            ans[count++][1]=inter[1];
            while(i<n){
                ans[count][0]=arr[i][0];
                ans[count++][1]=arr[i][1];
                i++;
            }
            int[][] ret=new int[count][2];
            for(int j=0;j<count;j++){
                ret[j]=ans[j];
            }
            return ret;
        }else if(end==-1){
            int[][] ans=new int[10001][2];
            int i=0;
            int count=0;
            while(i<start){
                ans[i][0]=arr[i][0];
                ans[i][1]=arr[i][1];
                i++;
                count++;
            }
            ans[i][0]=arr[i][0];
            ans[i++][1]=inter[1];
            count++;
            while(i<n && inter[1]>arr[i][1])i++;
            while(i<n){
                ans[count][0]=arr[i][0];
                ans[count][1]=arr[i][1];
                i++;
                count++;
            }
            int[][] ret=new int[count][2];
            for(int j=0;j<count;j++){
                ret[j]=ans[j];
            }
            return ret;
        }else{
            int[][] ans=new int[10001][2];
            int i=0;
            int count=0;
            while(inter[0]>arr[i][0]){
                ans[i]=arr[i];
                i++;
                count++;
            }
            ans[i][0]=inter[0];
            ans[i][1]=arr[end][1];
            i=end+1;
            count++;
            while(i<n){
                ans[count]=arr[i];
                i++;
                count++;
            }
            int[][] ret=new int[count][2];
            for(int j=0;j<count;j++){
                ret[j]=ans[j];
            }
            return ret;
        }
    }
}
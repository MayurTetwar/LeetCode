class Solution {
    public int minDeletionSize(String[] arr) {
        int ans=0;
        int n=arr.length;
        int m=arr[0].length();
        boolean[] f=new boolean[n];
        for(int i=0;i<m;i++){
            boolean flag=true;
            boolean same=false;
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<n-1;j++){
                if(f[j])continue;
                if(arr[j].charAt(i)>arr[j+1].charAt(i)){
                    list=new ArrayList<>();
                    flag=false;
                    break;
                }else if(arr[j].charAt(i)<arr[j+1].charAt(i)){
                    list.add(j);
                }else same=true;
            }
            if(flag){
                if(!same)return ans;
                for(int j:list)f[j]=true;
            }else ans++;
        }
        return ans;
    }
}
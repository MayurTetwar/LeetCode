class Solution {
    public int minimumPairRemoval(int[] arr) {

        int n=arr.length;
        int ans=0;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(arr[i]);
        }
        while(true){
            int j=0;
            for(j=1;j<n;j++){
                if(list.get(j-1)>list.get(j)){
                    break;
                }
            }
            if(j==n)break;
            int min=1000000;
            int ind=-1;
            for(j=1;j<n;j++){
                if(list.get(j)+list.get(j-1)<min){
                    min=list.get(j)+list.get(j-1);
                    ind=j;
                }
            }
            list.remove(ind);
            list.set(ind-1,min);
            n--;
            ans++;
            //System.out.println(list+" "+n);
        }
        return ans;
    }
}
class Solution {
    public int maximumSwap(int num) {
        String str=String.valueOf(num);
        char[] arr=str.toCharArray();
        int n=arr.length;
        for(int i=0;i<n;i++){
            int ind=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]>=arr[ind]){
                    ind=j;
                }
            }
            if(ind!=i && arr[ind]!=arr[i]){
                char ch=arr[ind];
                arr[ind]=arr[i];
                arr[i]=ch;
                str=new String(arr);
                return Integer.parseInt(str);
            }
        }
        return num;
    }
}
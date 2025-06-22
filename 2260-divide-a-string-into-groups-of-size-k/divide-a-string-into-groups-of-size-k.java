
class Solution {
    public String[] divideString(String s, int k, char fill) {
        String[] arr;
        int n=s.length();
        int len=-1;
        if(n%k==0){
            arr=new String[n/k];
            len=n/k;
        }else{
            arr=new String[(n/k)+1];
            len=n/k;
            len++;
        }
        int ind=-1;
       // StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            if(i%k==0){
                ind++;
                arr[ind]=String.valueOf(s.charAt(i));
            }else{
                arr[ind]+=String.valueOf(s.charAt(i));
            }
        }
        while(arr[len-1].length()<k){
            arr[len-1]+=String.valueOf(fill);
        }
        return arr;
    }
}
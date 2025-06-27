class Solution {
    String s;
    int n;
    public int maximumLength(String s) {
        this.s=s;
        n=s.length();
        int st=0;
        int end=n;
        while(st<end){
            int mid=(st+end+1)/2;
            if(helper(mid)){
                st=mid;
            }else{
                end=mid-1;
            }
        }
        return (st==0)?-1:st;
    }
    public boolean helper(int x){
        int[] count=new int[26];
        for(int i=0;i<n;){
            int j=i+1;
            while(j<n && s.charAt(j)==s.charAt(i)){
                j++;
            }
            int k=s.charAt(i)-'a';
            count[k]+=Math.max(0,j-i-x+1);
            if(count[k]>=3){
                return true;
            }
            i=j;
        }
        return false;
    }
}
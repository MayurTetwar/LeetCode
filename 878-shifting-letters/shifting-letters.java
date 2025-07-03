class Solution {
    public String shiftingLetters(String s, int[] arr) {
        
        int n=s.length();
        long[] pre=new long[n];
        pre[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            pre[i]=pre[i+1]+arr[i];
        }
        StringBuilder sb=new StringBuilder();
        int i=0;
        for(char ch:s.toCharArray()){
            long next=(ch-'a')+pre[i++];
            next=next%26;
            sb.append((char)(next+'a'));
        }
        return sb.toString();
    }
}
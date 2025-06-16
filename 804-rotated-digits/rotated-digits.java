class Solution {
    static int[] ans=new int[10001];
    static{
        getOrans(10000);
    }
    static public int getOrans(int n){
        int count=0;
       // System.out.println(n);
        for(int i=1;i<=n;i++){
            String s=String.valueOf(i);
            if(conOne(s) && conTwo(s))count++;
            ans[i]=count;
        }
        return count;
    }
    static public int rotatedDigits(int n) {
        return ans[n];
    }
    static public boolean conOne(String s){
        if(s.contains("2") || s.contains("5") || s.contains("6") || s.contains("9"))return true;
        return false;
    }
    static public boolean conTwo(String s){
        if(s.contains("3") || s.contains("4") || s.contains("7"))return false;
        return true;
    }
}
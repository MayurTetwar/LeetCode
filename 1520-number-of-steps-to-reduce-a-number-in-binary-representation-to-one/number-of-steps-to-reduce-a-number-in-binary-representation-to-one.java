class Solution {
    public int numSteps(String s) {
        int n=s.length();
        int ans=0;
        char[] ch=s.toCharArray();
        int i=n-1;
        boolean flag=false;
        while(i>0){
            if(ch[i]=='1'){
                int j=i-1;
                while(j>=0 && ch[j]=='1'){
                    ch[j]='0';
                    j--;
                }
                if(j>=0)ch[j]='1';
                else flag=true;
                ch[i]='0';
            }else{
                i--;
            }
            ans++;
            // System.out.println(Arrays.toString(ch));
        }
        if(flag){
            ans++;
        }
        return ans;
    }
}
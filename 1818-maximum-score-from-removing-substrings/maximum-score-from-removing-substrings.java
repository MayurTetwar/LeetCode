class Solution {
    public int maximumGain(String s, int x, int y) {
        char ch1='a';
        char ch2='b';
        int max=x,min=y;
        if(x<y){
            char temp=ch1;
            ch1=ch2;
            ch2=temp;
            max=y;
            min=x;
        }
        int ans=0;
        int n=s.length();
        boolean[] visi=new boolean[n];
        for(int i=0;i<n-1;){
            int j=i+1;
            while(i>=0 && j<n && s.charAt(i)==ch1 && s.charAt(j)==ch2){
                visi[i]=visi[j]=true;
                //System.out.println(i+" "+j);
                while(i>=0 && visi[i])i--;
                j++;
                ans+=max;
            }
            i=j;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++)if(!visi[i]){
            sb.append(s.charAt(i));
        }
        s=sb.toString();
        n=s.length();
        for(int i=0;i<n-1;){
            int j=i+1;
            while(i>=0 && j<n && s.charAt(i)==ch2 && s.charAt(j)==ch1){
                i--;
                j++;
                ans+=min;
            }
            i=j;
        }
        return ans;
    }
}
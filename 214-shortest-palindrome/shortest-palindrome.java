class Solution {
    public String shortestPalindrome(String s) {
        String r=rev(s);
        int n=s.length();
        int[] z=Zalgo(s.concat("$").concat(r));
        int ind = 0;
        for(int i = n + 1; i < z.length; i++){
            if(z[i] == z.length - i) {
                ind = z[i];
                break;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=n-1;i>=ind;i--){
            sb.append(s.charAt(i));
        }
        sb.append(s);
        return sb.toString();
    }
    public String rev(String s){
        char[] ch=s.toCharArray();
        int i=0,j=s.length()-1;
        while(i<j){
            char temp=ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
            i++;
            j--;
        }
        return new String(ch);
    }
    public int[] Zalgo(String s){
        int n=s.length();
        int[] z=new int[n];
        int l=0,r=0;
        int ind=0;
        for(int i=1;i<n;i++){
            if(i<=r){
                z[i]=Math.min(r-i+1,z[i-l]);
            }
            while(i+z[i]<n && s.charAt(z[i])==s.charAt(i+z[i]))z[i]++;
            if(i+z[i]-1>r){
                l=i;
                r=i+z[i]-1;
            }
            ind=Math.max(ind,z[i]);
        }
        return z;
    }
}
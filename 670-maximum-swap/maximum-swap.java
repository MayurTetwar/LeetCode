class Solution {
    public int maximumSwap(int num) {
        String str=String.valueOf(num);
        char[] ch=str.toCharArray();
        int n=ch.length;
        for(int i=0;i<n;i++){
            int max=-1;
            int ind=-1;
            for(int j=i;j<n;j++){
                if(max<=ch[j]-'0'){
                    max=ch[j]-'0';
                    ind=j;
                }
            }
            //System.out.println(max);
            if(max!=ch[i]-'0' && ind!=-1){
                char c=ch[i];
                ch[i]=ch[ind];
                ch[ind]=c;
                return Integer.parseInt(String.valueOf(ch));
            }
        }
        return num;
    }
}
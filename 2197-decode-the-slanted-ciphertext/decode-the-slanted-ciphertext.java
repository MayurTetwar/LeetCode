class Solution {
    public String decodeCiphertext(String str, int rows) {
        int len= str.length();
        int n=rows;
        int m=(int)Math.ceil(len/n);
      //  System.out.println(m+" "+len);
        StringBuilder ans=new StringBuilder();
        char[][] arr=new char[n][m];
        int j=-1,k=-1;
        for(int i=0;i<len;i++){
            if(i%m==0){
                k=0;
                j++;
            }
            arr[j][k++]=str.charAt(i);
        }
//         for(int i=0;i<n;i++){
// System.out.println(Arrays.toString(arr[i]));
//         }
        for(int i=0;i<m;i++){
            j=0;
            k=i;
            StringBuilder curr=new StringBuilder();
            while(j<n && k<m){
                curr.append(arr[j][k]);
                j++;
                k++;
            }
            ans.append(curr);
        }
        str = ans.toString();
        int i=str.length()-1;
        while(i>=0 && str.charAt(i)==' ')i--;
        return str.substring(0,i+1);
    }
}
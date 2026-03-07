class Solution {
    public int minFlips(String s) {
        int n=s.length();
        int[] one=new int[n];
        int[] zero=new int[n];
        boolean flag=true;
        for(int i=0;i<n;i++){
            if(flag){
                if(s.charAt(i)=='0')one[i]++;
            }else{
                if(s.charAt(i)=='1')one[i]++;
            }
            if(i>0)one[i]+=one[i-1];
            flag=!flag;
        }
        flag=false;
        for(int i=0;i<n;i++){
            if(flag){
                if(s.charAt(i)=='0')zero[i]++;
            }else{
                if(s.charAt(i)=='1')zero[i]++;
            }
            if(i>0)zero[i]+=zero[i-1];
            flag=!flag;
        }
        int ans=Math.min(one[n-1],zero[n-1]);
        // System.out.println(Arrays.toString(one));
        // System.out.println(Arrays.toString(zero));
        for(int i=0;i<n;i++){
            if(i%2!=(n-i)%2){
                ans=Math.min(ans,one[i]+zero[n-1]-zero[i]);
                ans=Math.min(ans,zero[i]+one[n-1]-one[i]);
            }
            // System.out.println(ans+" "+i);
        }
        return ans;
    }
}
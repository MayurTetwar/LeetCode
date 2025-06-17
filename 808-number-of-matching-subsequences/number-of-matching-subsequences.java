class Solution {
    public int numMatchingSubseq(String news, String[] arr) {
        int ans=0;
        int n=arr.length;
        int[][] map=new int[news.length()][26];
        
        int[] count=new int[26];
        Arrays.fill(count,-1);
        for(int i=news.length()-1;i>=0;i--){
            count[news.charAt(i)-'a']=i;
            map[i]=count.clone();
        }
        // for(int i=0;i<n;i++){
        //     System.out.println(Arrays.toString(map[i]));
        // }
        for(String str:arr){
            int i=0;
            int curr=0;
            for(i=0;i<str.length() && curr<news.length();i++){
              //  System.out.println(curr+" "+i);
                int ind=map[curr][str.charAt(i)-'a'];
                if(ind==-1)break;
                curr=ind+1;
            }
            if(i==str.length())ans++;
        }
        return ans;
    }
}
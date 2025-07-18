class Solution {
    public int inf=Integer.MAX_VALUE;
    // 3 visited used karna hai 0,1,2.
    public int largestPathValue(String s, int[][] arr) {
        int n=s.length();
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++)list.add(new ArrayList<>());
        for(int a[]:arr){
            if(a[0]==a[1])return -1;
            list.get(a[0]).add(a[1]);
        }
        int[] visi=new int[n];
        int[][] count=new int[n][26];
        int ans=0;
        for(int i=0;i<n && ans!=inf;i++){
            ans=Math.max(ans,helper(list,i,visi,count,s));
        }
        return (ans==inf)?-1:ans;
    }
    public int helper(List<List<Integer>> list,int curr,int[] visi,int[][] count,String s){
        int ch=s.charAt(curr)-'a';
        if(visi[curr]==1)return inf;
        if(visi[curr]==2)return count[curr][ch];
        visi[curr]=1;
        for(int neg:list.get(curr)){
            int ans=helper(list,neg,visi,count,s);
            if(ans==inf)return ans;
            for(int i=0;i<26;i++){
                count[curr][i]=Math.max(count[curr][i],count[neg][i]);
            }
        }
        visi[curr]=2;
        count[curr][ch]++;
        return count[curr][ch];
    }
}
/*
class Solution {

    public int inf=Integer.MAX_VALUE;
    public int largestPathValue(String s, int[][] arr) {
        int n=s.length();
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] a:arr){
            if(a[0]==a[1])return -1;
            list.get(a[0]).add(a[1]);
        }
        int ans=0;
        int[] visi=new int[n];
        int[][] col=new int[n][26];
        for(int i=0;i<n && ans!=inf;i++){
            ans=Math.max(ans,helper(col,visi,list,i,s));
        }
        return (ans==inf)?-1:ans;
    }
    public int helper(int[][] col,int[] visi,List<List<Integer>> list,int curr,String s){
        int ch=s.charAt(curr)-'a';
        if(visi[curr]==1)return inf;
        if(visi[curr]==2)return col[curr][ch];
        visi[curr]=1;
        for(int n:list.get(curr)){
            int val=helper(col,visi,list,n,s);
            if ( val== inf)
                return inf;
            for (int c = 0; c < 26; c++) {
                col[curr][c] = Math.max(col[curr][c], col[n][c]);
            }
        }
        visi[curr]=2;
        col[curr][ch]++;
        return col[curr][ch];
    }
}
*/
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[][] list=new int[500][2];
        int[][] map=new int[26][2];
        int k=0;
        for(int i=0;i<26;i++){
            Arrays.fill(map[i],-1);
        }
        int n=s.length();
        for(int i=0;i<n;i++){
            int pos=s.charAt(i)-'a';
            if(map[pos][0]==-1){
                map[pos][0]=i;
            }
            map[pos][1]=i;
        }
        boolean[] visi=new boolean[26];
        for(int i=0;i<n;i++){
            int pos=s.charAt(i)-'a';
            if(visi[pos])continue;
            //System.out.println(pos+" "+map[pos][0]+" "+map[pos][1]);
            visi[pos]=true;
            boolean flag=true;
            for(int j=0;j<k;j++){
                if((list[j][0]<=map[pos][0] && map[pos][0]<=list[j][1]) || (list[j][0]<=map[pos][1] && map[pos][1]<=list[j][1])){
                    //a[1]=Math.max(a[1],map[pos][1]);
                 //   System.out.println(list[j][1]+" "+map[pos][1]);
                    list[j][1]=Math.max(list[j][1],map[pos][1]);
                    flag=false;
                    break;
                }
            }
            if(flag){
             //   System.out.println(map[pos][0]+" "+map[pos][1]);
                list[k][0]=map[pos][0];
                list[k++][1]=map[pos][1];
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(list[i][1]-list[i][0]+1);
        }
        return ans;
    }
}
class Solution {
    int[] par;
    public int find(int x){
        if(par[x]!=x){
            par[x]=find(par[x]);
        }
        return par[x];
    }
    public void union(int x,int y){
        int com1=find(x);
        int com2=find(y);
        if(com1!=com2){
            par[com1]=com2;
        }
    }
    public List<Integer> findAllPeople(int n, int[][] m, int fp) {
        Arrays.sort(m,(a,b)->a[2]-b[2]);
        List<Integer> ans=new ArrayList<>();
        ans.add(0);
        ans.add(fp);
        par=new int[n];
        for(int i=0;i<n;i++)par[i]=i;
        union(0,fp);
        int i=0;
        while(i<m.length){
            if(m[i][0]==fp || m[i][1]==fp || m[i][0]==0 || m[i][1]==0)break;
            i++;
        }
        if(i==m.length)return ans;
        int time=m[i][2];
        while(i>0 && m[i-1][2]==time)i--;
        while(i<m.length){
            for(int j=i;j<m.length && m[i][2]==m[j][2];j++){
                // System.out.println(m[j][0]+" "+m[j][1]);
                union(m[j][0],m[j][1]);
            }
            // for(int k=0;k<n;k++){
                
            // }
            // System.out.println();
            int com=find(fp);
            int last=-1;
            for(int j=i;j<m.length && m[i][2]==m[j][2];j++){
                if(com!=find(m[j][0])){
                    // System.out.println(find(m[i][0])+" "+find(m[i][1])+" "+com);
                    par[m[j][0]]=m[j][0];
                    par[m[j][1]]=m[j][1];
                }
                last=j;
            }
            i=last+1;
        }
        int com=find(fp);
        for(i=1;i<n;i++){
            if(com==find(i) && i!=fp)ans.add(i);
        }
        return ans;
    }
}
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
        if(com1==com2)return;
        par[com1]=com2;
    }
    public List<List<String>> accountsMerge(List<List<String>> list) {
        int n=list.size();
        par=new int[n];
        int[] map=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
            map[i]=-1;
        }
        List<Set<String>> listSet=new ArrayList<>();
        for(List<String> user:list){
            Set<String> set=new HashSet<>();
            boolean name=true;
            for(String email:user){
                if(name){
                    name=false;
                }else set.add(email);
            }
            listSet.add(set);
        }
        System.out.println(listSet);
        Set<String> visi=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<list.get(i).size();j++){
                if(visi.contains(list.get(i).get(j)))continue;
                visi.add(list.get(i).get(j));
                for(int k=i+1;k<n;k++){
                    if(listSet.get(k).contains(list.get(i).get(j))){
                        union(i,k);
                    }
                }
            }
        }
        List<TreeSet<String>> ansSort=new ArrayList<>();
        List<List<String>> ans=new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     System.out.println(find(i));
        // }
        String[] arr=new String[n];
        int pos=0;
        for(int i=0;i<n;i++){
            int com=find(i);
            if(map[com]==-1){
                arr[pos]=list.get(i).get(0);
                map[com]=pos++;
                // TreeSet<String> ts = new TreeSet<>(list.get(i));
                // ansSort.add(ts);
                TreeSet<String> user=new TreeSet<>();
                for(int j=1;j<list.get(i).size();j++){
                    user.add(list.get(i).get(j));
                }
                ansSort.add(user);
            }else{
                TreeSet<String> user=new TreeSet<>();
                for(int j=1;j<list.get(i).size();j++){
                    user.add(list.get(i).get(j));
                }
                ansSort.get(map[com]).addAll(user);
            }
        }
        for(TreeSet<String> u:ansSort){
            ans.add(new ArrayList<>(u));
        }
        for(int i=0;i<n;i++){
            if(arr[i]!=null){
                ans.get(i).add(0,arr[i]);
            }
        }
        return ans;
    }
}
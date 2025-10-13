class Solution {
    public int minimumDiameterAfterMerge(int[][] e1, int[][] e2) {
        List<List<Integer>> list1=new ArrayList<>();
        List<List<Integer>> list2=new ArrayList<>();
        int n=e1.length;
        int m=e2.length;
        for(int i=0;i<=Math.max(m,n);i++){
            list1.add(new ArrayList<>());
            list2.add(new ArrayList<>());
        }
        for(int[] e:e1){
            list1.get(e[0]).add(e[1]);
            list1.get(e[1]).add(e[0]);
        }
        for(int[] e:e2){
            list2.get(e[0]).add(e[1]);
            list2.get(e[1]).add(e[0]);
        }
        int[] res1=helper(list1,n,0);
        int[] ans1=helper(list1,n,res1[0]);

        int[] res2=helper(list2,m,0);
        int[] ans2=helper(list2,m,res2[0]);
        // System.out.println(ans1[1]+" "+ans2[1]);
        int maxdist=Math.max(ans1[1],ans2[1]);
        return Math.max(((ans1[1]+1)/2)+((ans2[1]+1)/2)+1,maxdist);
    }
    public static int[] helper(List<List<Integer>> list,int n,int st){
        // if(n==0)return new int[]{1000000,0};
        Queue<Integer> q=new LinkedList<>();
        boolean[] visi=new boolean[n+1];
        int d=0;
        int res=0;
        q.add(st);
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int curr=q.poll();
                res=curr;
                visi[curr]=true;
                for(int neg:list.get(curr)){
                    if(!visi[neg]){
                        q.add(neg);
                    }
                }
            }
            d++;
        }
        return new int[]{res,d-1};
    }
}
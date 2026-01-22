class Solution {
    int[] tree;
    int n;
    public void build(int[] arr,int st,int end,int node){
        if(st==end){
            tree[node]=arr[st];
        }else{
            int mid=(st+end)/2;
            build(arr,st,mid,node*2);
            build(arr,mid+1,end,node*2+1);
            tree[node]=Math.max(tree[node*2],tree[node*2+1]);
        }
    }
    public int query(int l,int r,int st,int end,int node){
        if(r<st || end<l)return -1;
        if(l<=st && end<=r){
            return tree[node];
        }else{
            int mid=(st+end)/2;
            int left=query(l,r,st,mid,node*2);
            int right=query(l,r,mid+1,end,node*2+1);
            return Math.max(left,right);
        }
    }
    public int maxCapacity(int[] a, int[] c, int bud){
        n=a.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((m,b)->a[m]-a[b]);
        for(int i=0;i<n;i++)pq.add(i);
        int[] arr=new int[n];
        int[] cap=new int[n];
        int j=0;
        while(!pq.isEmpty()){
            int i=pq.poll();
            arr[j]=a[i];
            cap[j]=c[i];
            j++;
        }

        tree=new int[4*n];
        build(cap,0,n-1,1);
        int max=0;
        // l r st snd node
        int left=0;
        int right=n-1;
        while(left<right){
            while(left<right && arr[left]+arr[right]>=bud)right--;
            if(left<right){
                int c1=cap[left];
                int c2=query(left+1,right,0,n-1,1);
                max=Math.max(max,c1+c2);
            }
            left++;
        }
        for(int i=0;i<n && arr[i]<bud;i++){
            max=Math.max(max,cap[i]);
        }
       // System.out.println(query(0,n-1,0,n-1,1));
        return max;
    }
}
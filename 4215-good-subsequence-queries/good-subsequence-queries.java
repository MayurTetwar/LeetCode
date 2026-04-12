class Solution {
    int p;
    Node[] tree;
    int[] arr;
    static class Node{
        long gcd;
        int cnt;  
        public Node(){
            
        } 
    }
    public long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
    private void build(int[] arr, int node, int start, int end) {
        tree[node]=new Node();
        if (start == end) {
            if(arr[start]%p==0){
                tree[node].gcd = arr[start];
                tree[node].cnt = 1;
            } 
        } else {
            int mid = (start + end) / 2;
            build(arr, 2 * node, start, mid);
            build(arr, 2 * node + 1, mid + 1, end);
            tree[node].gcd = gcd(tree[2 * node].gcd , tree[2 * node + 1].gcd);
            tree[node].cnt = tree[2 * node].cnt + tree[2 * node + 1].cnt;
        }
    }
    private long query(int node, int start, int end, int L, int R) {
        if (R < start || end < L) { // no overlap
            return 0;
        }
        if (L <= start && end <= R) { // total overlap
            return tree[node].gcd;
        }
        int mid = (start + end) / 2; // partial overlap
        long leftSum = query(2 * node, start, mid, L, R);
        long rightSum = query(2 * node + 1, mid + 1, end, L, R);
        return gcd(leftSum , rightSum);
    }

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node].gcd = 0;
            tree[node].cnt=0;
            if(val%p==0){
                tree[node].gcd =val;  
                tree[node].cnt=1;
                
            } 
        } else {
            int mid = (start + end) / 2;
            if (idx <= mid) {
                update(2 * node, start, mid, idx, val);
            } else {
                update(2 * node + 1, mid + 1, end, idx, val);
            }
            tree[node].gcd = gcd(tree[2 * node].gcd , tree[2 * node + 1].gcd);
            tree[node].cnt = tree[2 * node].cnt + tree[2 * node + 1].cnt;
        }
    }
    public int countGoodSubseq(int[] arr, int p, int[][] queries) {
        this.arr=arr;
        this.p=p;
        int n=arr.length;
        // if(n==2)return 0;
        int count=0;
        if(arr[0]==p)count++;
        if(arr[1]==p)count++;
        tree=new Node[n*4];
        build(arr,1,0,n-1);
            // System.out.println(queries.length);

        int ans=0;
        int ans2=0;
        int k=0;
        for(int[] q:queries){
            update(1,0,n-1,q[0],q[1]);
            arr[q[0]]=q[1];
             k++;
             
            if(tree[1].gcd==p){
                if(tree[1].cnt<n){
                    ans++;
                    continue;
                }
                for(int i = 0; i < n; i++){
                    long g=0;
                    if(i>0)g = query(1,0,n-1,0,i-1);
                    if(i < n-1) g = gcd(g, query(1,0,n-1, i+1, n-1));
                    // if(g==p){
                    //     System.out.println(Arrays.toString(arr));
                    // }
                    if(g==p){
                        ans++;
                        break;
                    }
                }
            }
        }
        
        return ans;
    }
    /*
    [4,8,12,16]
2
[[0,3],[2,6]]
[4,5,7,8]
3
[[1,4],[2,8]]
[2,3]
1
[[0,4],[1,6]]
[14,4,13,21]
3
[[0,8],[0,12]]
[1,6]
7
[[0,7]]
[15015,10010,6006,4290,2730,2310]
1
[[0,15015]]
[21,64,95]
1
[[0,56],[2,96],[2,49],[1,18],[0,36],[0,82],[2,56],[1,79],[1,24],[2,95],[2,27],[2,12],[0,79],[1,54],[1,41],[1,66],[2,36],[2,82],[0,100],[0,95],[1,1],[2,24],[1,93],[0,32],[0,64],[2,47],[2,36],[0,11],[0,66],[2,13],[2,38],[1,57],[1,65],[0,15],[0,21],[1,64],[2,95]]
[50,84,90]
3
[[1,74],[2,98],[1,35],[0,59],[1,65],[0,82],[1,41],[1,29],[1,65],[2,68],[0,91],[0,19],[0,89],[2,35],[2,19],[0,100],[2,37],[1,94],[0,67],[2,25],[0,27],[2,86],[1,82],[2,55],[0,65],[1,73],[1,88],[1,77],[2,52],[2,36],[0,44],[1,38],[1,84],[1,63],[0,68],[2,32],[1,24],[0,49],[0,45],[2,40],[1,70],[1,69],[0,20],[2,76],[2,97],[0,96],[1,93],[2,75],[0,65],[1,80],[2,33],[0,7],[0,61],[1,20],[2,89],[0,72],[0,25],[2,31],[1,3],[0,81],[2,28],[2,30],[1,63],[0,84],[2,90],[2,90],[1,84],[0,50]]
    */
}
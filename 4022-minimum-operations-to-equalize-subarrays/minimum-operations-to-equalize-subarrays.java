class Solution {
    public long[] minOperations(int[] a, int k, int[][] queries) {
        n = a.length;
        int gn=1;
        int curr=a[0]%k;
        int[] g=new int[n];
        for(int i=0;i<n;i++){
            if(curr!=a[i]%k){
                gn++;
                curr=a[i]%k;
            }
            g[i]=gn;
        }
        tree = new ArrayList[4*n];
        pref = new ArrayList[4*n];
        build(1, 0, n-1, a);
        long[] ans=new long[queries.length];
        int i=0;
        for (int[] q : queries) {
            int l = q[0], r = q[1];
            if(g[l]!=g[r]){
                ans[i++]=-1;
                continue;
            }
            long result = absSum(l, r);
            ans[i++]=(result/k);
        }
        return ans;
    }

    int n;
    ArrayList<Integer>[] tree;
    ArrayList<Long>[] pref;

    void build(int node, int l, int r, int[] a) {
        tree[node] = new ArrayList<>();
        pref[node] = new ArrayList<>();

        if (l == r) {
            tree[node].add(a[l]);
            pref[node].add((long) a[l]);
            return;
        }

        int mid = (l+r)>>1;
        build(node<<1, l, mid, a);
        build(node<<1|1, mid+1, r, a);

        tree[node].addAll(tree[node<<1]);
        tree[node].addAll(tree[node<<1|1]);
        Collections.sort(tree[node]);

        long sum = 0;
        for (int x : tree[node]) {
            sum += x;
            pref[node].add(sum);
        }
    }

    int countLE(int node, int l, int r, int ql, int qr, int x) {
        if (qr < l || r < ql) return 0;
        if (ql <= l && r <= qr) {
            return upperBound(tree[node], x);
        }
        int mid = (l+r)>>1;
        return countLE(node<<1, l, mid, ql, qr, x) +
               countLE(node<<1|1, mid+1, r, ql, qr, x);
    }

    long sumLE(int node, int l, int r, int ql, int qr, int x) {
        if (qr < l || r < ql) return 0;
        if (ql <= l && r <= qr) {
            int k = upperBound(tree[node], x);
            return k == 0 ? 0 : pref[node].get(k-1);
        }
        int mid = (l+r)>>1;
        return sumLE(node<<1, l, mid, ql, qr, x) +
               sumLE(node<<1|1, mid+1, r, ql, qr, x);
    }

    long totalSum(int node, int l, int r, int ql, int qr) {
        if (qr < l || r < ql) return 0;
        if (ql <= l && r <= qr) {
            return pref[node].get(pref[node].size()-1);
        }
        int mid = (l+r)>>1;
        return totalSum(node<<1, l, mid, ql, qr) +
               totalSum(node<<1|1, mid+1, r, ql, qr);
    }

    int kth(int l, int r, int k) {
        int lo = 1, hi = (int)1e9, ans = -1;
        while (lo <= hi) {
            int mid = (lo+hi)>>1;
            int cnt = countLE(1, 0, n-1, l, r, mid);
            if (cnt >= k) {
                ans = mid;
                hi = mid - 1;
            } else lo = mid + 1;
        }
        return ans;
    }

    int upperBound(ArrayList<Integer> arr, int x) {
        int l=0, r=arr.size();
        while(l<r){
            int m=(l+r)>>1;
            if(arr.get(m)<=x) l=m+1; else r=m;
        }
        return l;
    }

    long absSum(int l, int r) {
        int len = r - l + 1;
        int median = kth(l, r, (len+1)/2);

        long tot = totalSum(1, 0, n-1, l, r);
        long sumL = sumLE(1, 0, n-1, l, r, median);
        int cntL = countLE(1, 0, n-1, l, r, median);

        long sumR = tot - sumL;
        int cntR = len - cntL;

        return median * 1L * cntL - sumL + sumR - median * 1L * cntR;
    }
    
    
}
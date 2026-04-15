class Solution {
    public int closestTarget(String[] arr, String target, int startIndex) {
        int n=arr.length;
        int left=0;
        int right=n-1;
        while(left<n && !arr[left].equals(target))left++;
        while(right>=0 && !arr[right].equals(target))right--;

        int sleft=startIndex;
        int sright=startIndex;
        while(sleft>=0 && !arr[sleft].equals(target))sleft--;
        while(sright<n && !arr[sright].equals(target))sright++;

        int min=n;
        if(sleft!=-1)min=Math.min(min,startIndex-sleft);
        if(sright!=n)min=Math.min(min,sright-startIndex);
        if(left!=n)min=Math.min(min,n-startIndex+left);
        if(right!=-1)min=Math.min(min,n+startIndex-right);
        if(min<n)return min;
        return -1;
    }
}
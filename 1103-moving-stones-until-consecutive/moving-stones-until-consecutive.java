class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] arr={a,b,c};
        Arrays.sort(arr);
        int max=arr[2]-arr[0]-2;
        int min=Integer.MAX_VALUE;
        if(arr[0]+1==arr[1] && arr[1]+1==arr[2])min=0;
        else if(arr[0]+1==arr[1] || arr[1]+1==arr[2] || arr[0]+2==arr[1] || arr[1]+2==arr[2])min=1;
        else min=2;
        return new int[]{min,max};
    }
}
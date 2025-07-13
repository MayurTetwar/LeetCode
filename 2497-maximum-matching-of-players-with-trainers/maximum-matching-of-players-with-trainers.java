class Solution {
    public int matchPlayersAndTrainers(int[] play, int[] tr) {
        int n=tr.length;
        Arrays.sort(play);
        Arrays.sort(tr);
        int ans=0,j=0;

        for(int i=0;i<n && j<play.length;i++){
            if(play[j]<=tr[i]){
                j++;
            }
        }
        return j;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> list=new ArrayList<>();
        fillList(root,list);
        Collections.sort(list);
        //System.out.println(list);
        List<List<Integer>> ans=new ArrayList<>();
        for(int num:queries){
            int ind=helper(list,num);
//System.out.println(ind);
            List<Integer> toAdd=new ArrayList<>();
            if(ind>=0 && ind<list.size()){
                if(list.get(ind)==num){
                    toAdd.add(num);
                    toAdd.add(num);
                    ans.add(toAdd);
                    continue;
                }else{
                    toAdd.add(list.get(ind));
                }
            }else toAdd.add(-1);
            if(ind+1<list.size())toAdd.add(list.get(ind+1));
            else toAdd.add(-1);
            ans.add(toAdd);
        }
        return ans;
    }
    public int helper(List<Integer> list,int tar){
        int st=0;
        int end=list.size()-1;
        while(st<=end){
            int mid=(end-st)/2+st;
            if(list.get(mid)==tar)return mid;
            if(list.get(mid)<tar){
                st=mid+1;
            }else{
                end=mid-1;
            }
        }
        return end;
    }
    public void fillList(TreeNode root,List<Integer> list){
        if(root==null)return;
        list.add(root.val);
        fillList(root.left,list);
        fillList(root.right,list);
    }
}
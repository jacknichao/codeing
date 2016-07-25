import java.util.ArrayList;

/**
 * Created by root on 7/24/16.
 * 题目描述

 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 *
 */
public class FindPath {
    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> arrs = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmpPath=new ArrayList<Integer>();
        if (root != null) {
            FindPath(root, target, 0, arrs,tmpPath);
        }
        return arrs;
    }

    public void FindPath(TreeNode root, int target, int currentSum, ArrayList<ArrayList<Integer>> arrs, ArrayList<Integer> tmpPath){

        currentSum+=root.val;
        tmpPath.add(root.val);

        boolean isLeaf=root.left==null&&root.right==null;

        if(currentSum==target&&isLeaf){
            ArrayList<Integer> list=new ArrayList<Integer>(tmpPath);
            arrs.add(list);
        }
        //递归在左右子树上查找
        if(root.left!=null)
            FindPath(root.left,target,currentSum,arrs,tmpPath);

        if(root.right!=null)
            FindPath(root.right,target,currentSum,arrs,tmpPath);

        //返回父节点
        tmpPath.remove(tmpPath.size()-1);
    }
}

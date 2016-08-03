/**
 * Created by root on 16-7-27.
 *
 题目描述
 输入一棵二叉树，判断该二叉树是否是平衡二叉树。

 */
public class BalanceBinaryTree {
    public static void main(String[] args) {

    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null) return true;

        int left=TreeDepth(root.left);
        int right=TreeDepth(root.right);
        int diff=left-right;
        if(diff>1 || diff<-1)
            return false;
        return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);

    }

    public int TreeDepth(TreeNode root){
        if(root==null) return 0;

        int left=TreeDepth(root.left);
        int right=TreeDepth(root.right);
        return left>right?left+1:right+1;
    }
}

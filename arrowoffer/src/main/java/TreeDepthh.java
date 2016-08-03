/**
 * Created by root on 16-7-27.
 *
 题目描述
 输入一棵二叉树，求该树的深度。
 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

 */
public class TreeDepthh {
    public static void main(String[] args) {

    }

    public int TreeDepth(TreeNode pRoot){
        if(pRoot==null) return 0;
        else return TreeDepth(pRoot,1);
    }

    public int TreeDepth(TreeNode pRoot,int currentLength)
    {
        if(pRoot==null) return currentLength;

        int maxLength=currentLength;
        if(pRoot.left!=null){
            int temp=TreeDepth(pRoot.left,currentLength+1);
            if(temp>maxLength)
                maxLength=temp;
        }

        if(pRoot.right!=null){
            int tmp=TreeDepth(pRoot.right,currentLength+1);
            if(tmp>maxLength)
                maxLength=tmp;
        }

        return maxLength;
    }
}

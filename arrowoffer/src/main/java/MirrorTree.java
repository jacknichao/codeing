/**
 * Created by root on 7/21/16.
 */
public class MirrorTree {
    public static void main(String[] args) {



    }

    public void Mirror(TreeNode root) {

        if(root==null) return ;
        if(root.left!=null) Mirror(root.left);
        if(root.right!=null) Mirror(root.right);
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
    }
}




/**
 * Created by root on 7/21/16.
 */
public class SubTree {
    public static void main(String[] args) {

    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result=false;
        if(root1!=null&&root2!=null){
            if(root1.val==root2.val){
                result=findSubTree(root1,root2);
            }
            if(!result) result=HasSubtree(root1.left,root2);
            if(!result) result=HasSubtree(root1.right,root2);
        }

        return result;

    }
    public boolean findSubTree(TreeNode root1,TreeNode root2){
        if(root2!=null&&root1==null) return false;
        if(root2==null&&root1==null) return true;

        if(root1.val!=root2.val) return false;
        return findSubTree(root1.left,root2)&&findSubTree(root1.right,root2);

    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}

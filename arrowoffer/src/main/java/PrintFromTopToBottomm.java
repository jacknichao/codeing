import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by root on 7/22/16.
 * 题目描述

 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottomm {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList=new LinkedList<Integer>();
        linkedList.add(12);
        linkedList.add(23);
        linkedList.add(1223);
        System.out.println(Arrays.toString(linkedList.toArray()));
        linkedList.peek();
        System.out.println(Arrays.toString(linkedList.toArray()));
        System.err.println(linkedList.getFirst());
        linkedList.remove();
        System.out.println(Arrays.toString(linkedList.toArray()));



    }

    //该方法在nowcoder中不认
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> elements=new ArrayList<Integer>();
        if(root!=null){
            LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
            queue.add(root);

            while(!queue.isEmpty()){
                TreeNode current=queue.getFirst();
                elements.add(current.val);
                if(current.left!=null) queue.add(current.left);
                if(current.right!=null) queue.add(current.right);
                queue.removeFirst();
            }
        }

        return elements;
    }

    public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root){
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        if(root!=null){
            ArrayList<TreeNode> treeNodes=new ArrayList<TreeNode>();
            treeNodes.add(root);
            while(!treeNodes.isEmpty()){
                TreeNode node=treeNodes.get(0);
                arrayList.add(node.val);
                treeNodes.remove(0);
                if(node.left!=null) treeNodes.add(node.left);
                if(node.right!=null) treeNodes.add(node.right);
            }
        }
        return arrayList;
    }
}

import java.util.*;
public class Diameter_of_Tree
{

    static class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int indx = -1;
        public static Node builtTree(int nodes[])
        {
            indx++;
            if(nodes[indx] == -1)
            {
                return null;
            }
            Node newNode = new Node(nodes[indx]);
            newNode.left = builtTree(nodes); 
            newNode.right = builtTree(nodes);
            
            return newNode;
        }

    }
    /* 
    public static int levelOfTree(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        int left = levelOfTree(root.left);
        int right = levelOfTree(root.right);
        return Math.max(left,right) +1;
    }

    public static int diameter(Node root)
    {
        if(root == null)
        {
            return 0;
        }

        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = levelOfTree(root.left) + levelOfTree(root.right)+1;

        return (Math.max(diam3 , Math.max(diam1,diam2)));
    }
*/
    static class TreeInfo
    {
        int height;
        int diam;

        TreeInfo(int ht , int diam)
        {
            this.height = ht;
            this.diam = diam;
        }
    }

    public static TreeInfo diameter(Node root)
    {
        if(root == null)
        {
            return new TreeInfo(0,0);
        }

        TreeInfo left = diameter(root.left);
        TreeInfo right = diameter(root.right);

        int height = Math.max(left.height , right.height) + 1;

        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = left.height + right.height + 1;

        int diam = Math.max(diam3 , Math.max(diam1,diam2));

        TreeInfo myTree = new TreeInfo(height , diam);
        return myTree;
    }

    public static void main(String [] args)
    {
        int nodes[]  = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.builtTree(nodes); 
        System.out.println(diameter(root).diam);
    }
}

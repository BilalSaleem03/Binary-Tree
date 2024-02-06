import java.util.*;
public class Summ_of_Nodes
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

    public static int countNodes(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left+right+root.data;
    }


    public static void main(String [] args)
    {
        int nodes[]  = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.builtTree(nodes); 
        System.out.println(countNodes(root));
    }
}

package main;

import java.util.MissingResourceException;
import java.util.logging.Logger;

public class BinaryTree<T extends Comparable<T>> {
    Node<T> root;
    int size;
    protected static Logger LOGGER = Logger.getLogger("LOGGER");;

    public BinaryTree() throws MissingResourceException {
        root = null;
        size = 0;
    }

    /**
     * Returns the size of the tree
     * @return
     */
    public int getSize(){
        return this.size;
    }

    /**
     * Adds another node into the Binary Tree
     * @param data
     * @return this binary tree
     */
    public BinaryTree insert(T data) {
        size += 1;
        if (root == null) {
            root = new Node(data);
            return this;
        }
        addToNode(root, data);
        return this;
    }

    /**
     * Traverses the tree recursively until it finds a place to add the node
     * @param node
     * @param data
     */
    private void addToNode(Node node, T data) {

        if(node.data.compareTo(data) < 0) {
            // If current Node is smaller than new one - look right
            if (node.right != null) {
                addToNode(node.right, data);
            } else {
                node.right = new Node(data);
            }
        } else if (node.data.compareTo(data) > 0) {
            // If current Node is bigger than new one - look left
            if(node.left != null) {
                addToNode(node.left, data);
            } else {
                node.left = new Node(data);
            }
        }
    }

    /**
     * Checks if a node with specific data exists in the tree
     * @param data
     * @return boolean
     */
    public boolean isNodeAvailable(T data){
        return findNode(root, data) != null;
    }

    /**
     * Traverses to tree to find the matching node
     * @param node
     * @param data
     * @return List<Node, ParentNode>
     */
    private Node parentNode;
    private Node findNode(Node node, T data) {
        if(node == null)
            return null;

        if(node.data.compareTo(data) < 0) {
            // look right
            LOGGER.info("Looked Right on this node: " + node.data);
            return findNode(node.right, data);
        } else if (node.data.compareTo(data) > 0) {
            //look left
            LOGGER.info("Looked Left on this node: " + node.data);
            return findNode(node.left, data);
        } else {
            return node;
        }
    }

    public String toString(){
        return "This is a tree! |-|-|";
    }


    /**
     * Implementation of the tree Node
     * @param data
     * @param left
     * @param right
     */
    private class Node<T extends Comparable<T>> {
        T data = null;
        Node<T> left = null;
        Node<T> right = null;

        public Node(T data) {
            this.data = data;
        }
    }

}

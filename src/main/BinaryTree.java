package main;

public class BinaryTree<T extends Comparable<T>> {
    Node<T> head;
    int size;

    public BinaryTree() {
        head = null;
        size = 0;
    }

    /**
     * Adds another node into the Binary Tree
     * @param data
     * @return this binary tree
     */
    public BinaryTree add(T data) {
        if (head == null) {
            head = new Node(data);
            return this;
        }
        addToNode(head, data);
        size += 1;
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

    public boolean isNodeAvailable(T data){
        return findNode(head, data) != null;
    }

    /**
     * Traverses to tree to find the matching node
     * @param node
     * @param data
     * @return
     */
    private Node findNode(Node node, T data) {
        if(node == null)
            return null;

        if(node.data.compareTo(data) < 0) {
            System.out.println("Looked Right on this node: " + node.data);
            // look right
            return findNode(node.right, data);
        } else if (node.data.compareTo(data) < 0) {
            System.out.println("Looked Left on this node: " + node.data);
            //look left
            return findNode(node.left, data);
        } else {
            return node;
        }
    }

    public String toString(){
        return "This is a tree! |-|-|";
    }




    private class Node<T extends Comparable<T>> {
        T data = null;
        Node<T> left = null;
        Node<T> right = null;

        public Node(T data) {
            this.data = data;
        }
    }

}

public class BinarySearchTree<E extends Comparable>{
    //instantiate both root and node
    private TreeNode<E> root;
    private TreeNode<E> node;
    //display method
    public void display(String message){
        //print message
        System.out.println(message);
        //set node to root
        TreeNode<E> node = root;
        //traverse from root
        traversal(node);
    }
    public boolean remove(E value) {
        //start at first node
        TreeNode<E> parent = null;
        TreeNode<E> node = root;
        //as long as the first node is not null
        while (node != null) {
            //comparisons between current value and the value we are searching to remove

            //if it is less than, we know that the values that are less than the current value are to the left
            if (value.compareTo(node.value) < 0) {
                parent = node;
                node = node.left;
            }
            //if it is greater than, we know that the values that are greater than the current value are to the left
            else if (value.compareTo(node.value) > 0) {
                parent = node;
                node = node.right;
            }
            //we found the value!!
            else {
                break;
            }
        }
        //the value does not exist if the root is null
        if (node == null) {
            return false;
        }
        //create new root
        if (node.left == null) {

            if (parent == null) {
                root = node.right;
            }
            else {
                if (value.compareTo(parent.value) < 0) {
                    parent.left = node.right;
                }
                else {
                    parent.right = node.right;
                }
            }
        }
        //we know that the maximum value is to the right
        else {
            TreeNode<E> parentRight = node;
            TreeNode<E> right = node.left;
            //traverse right
            while (right.right != null) {
                parentRight = right;
                right = right.right;
            }
            //gather max
            node.value = right.value;
            if (parentRight.right == right) {
                parentRight.right = right.left;
            }
            else {
                parentRight.left = right.left;
            }
        }
        return true;
    }
    //search method
    public boolean search(E value){
        //set the node to root
        TreeNode<E> node = root;
        //while there is still a node to reference
        while (node != null) {
            //comparisons, same as in remove method
            if (value.compareTo(node.value) < 0) {
                node = node.left;
            }
            else if (value.compareTo(node.value) > 0) {
                node = node.right;
            }
            else {
                return true;
            }
        }

        return false;

    }
    //insert method
    public boolean insert(E value){
        TreeNode<E> node = new TreeNode<>(value);
        //if there are no nodes, insert at root
        if (root == null) {
            root = node;
            return true;
        }
        //set parent and node to initial state
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (value.compareTo(current.value) < 0) {
                parent = current;
                current = current.left;
            } else if (value.compareTo(current.value) > 0) {
                parent = current;
                current = current.right;
            }
            else {
                return false;
            }
        }
        if (value.compareTo(parent.value) < 0) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return true;

    }
    //traversal method
    private void traversal(TreeNode<E> node){
        if(node == null) return;

        traversal(node.left);
        System.out.println(node.value);
        traversal(node.right);
    }
    //numberNodes get method essentially
    public int numberNodes(){
        return numberNodes(root);
    }
    //recursive numberNodes method
    public int numberNodes(TreeNode node){
        //count starts at one since root exists
        int count = 1;
        if(node == null){
            return 0;
        }
        else{
            //count if there are still nodes
            count+= numberNodes(node.right);

            count+= numberNodes(node.left);
            return count;
        }
    }
    //another get method
    int numberLeafNodes(){
        return numberLeafNodes(root);
    }
    //very similar to the numberNodes method, but now only counting lead nodes
    public int numberLeafNodes(TreeNode current){
        if(current == null){
            return 0;
        }
        if(current.left == null && current.right == null){
            return 1;
        }
        else{
            return numberLeafNodes(current.left) + numberLeafNodes(current.right);
        }
    }
    //another getter
    public int height(){
        return height(root);

    }
    //recursive height count
    int height(TreeNode node){
        if (node == null)
            return 0;
        else if (node.left == null && node.right == null){
            return 0;
        }
        else {
            int left = height(node.left);
            int right = height(node.right);

            if (left > right)
                return (left + 1);
            else
                return (right + 1);
        }
    }
    private class TreeNode<E> {
        public E value;
        public TreeNode<E> left;
        public TreeNode<E> right;

        public TreeNode(E value) {
            this.value = value;
        }
    }
}

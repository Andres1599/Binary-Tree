public class BinaryTree {

    Node root;

    /*
     * recursive function to assing person in order of the id
     */
    private Node addRecurvive(Node current, int id, int edad, String nombre) {

        if (current == null) {
            return new Node(id, edad, nombre);
        }

        if (id < current.id) {
            current.leftNode = addRecurvive(current.leftNode, id, edad, nombre);
        } else if (id > current.id) {
            current.rightNode = addRecurvive(current.rightNode, id, edad, nombre);
        } else {
            return current;
        }

        return current;
    }

    /*
     * funcition to add a new element to de tree
     */
    public void add(int id, int edad, String nombre) {
        root = addRecurvive(root, id, edad, nombre);
    }

    /*
     * find smallest value on the both sides in tree
     */
    private int findSmallestValue(Node root) {
        return root.leftNode == null ? root.id : findSmallestValue(root.leftNode);
    }

    /*
     * delete recursive element inside of the tree
     */
    private Node deleteRecursive(Node current, int id) {
        if (current == null) {
            return null;
        }

        if (id == current.id) {

            /*
             * in case the current node has no childrens
             */
            if (current.leftNode == null && current.rightNode == null) {
                return null;
            }

            /*
             * in case the current node has no right childrens
             */
            if (current.rightNode == null) {
                return current.leftNode;
            }

            /*
             * in case the curren node has no left childrens
             */
            if (current.leftNode == null) {
                return current.rightNode;
            }

            /*
             * in case the current node has children on both sides
             */

            int smallestValue = findSmallestValue(current.rightNode);
            current.id = smallestValue;
            current.rightNode = deleteRecursive(current.rightNode, smallestValue);
            return current;
        }
        if (id < current.id) {
            current.leftNode = deleteRecursive(current.leftNode, id);
            return current;
        }

        current.rightNode = deleteRecursive(current.rightNode, id);
        return current;
    }

    /*
     * Delete element by id value
     */
    public void delete(int id) {
        root = deleteRecursive(root, id);
    }

    /*
     * print BinaryTree in Pre-order
     */
    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.id);
            traversePreOrder(node.leftNode);
            traversePreOrder(node.rightNode);
        }
    }

    /*
     * print BinaryTree in post orden
     */
    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.leftNode);
            traversePostOrder(node.rightNode);
            System.out.print(" " + node.id);
        }
    }

    /*
     * print tree with format
     */
    public void printBinaryTree(Node root, int level) {
        if (root == null)
            return;
        printBinaryTree(root.rightNode, level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++)
                System.out.print("|\t");
            System.out.println("|--" + root.id + ":" + root.nombre);
        } else
            System.out.println(root.id);
        printBinaryTree(root.leftNode, level + 1);
    }
}
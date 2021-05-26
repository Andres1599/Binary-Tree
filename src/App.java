public class App {
    public static void main(String[] args) throws Exception {

        /* insertar datos de la U aqui */
        System.out.print(" Steed Carpio \n");

        /* crear el arbol binario */
        BinaryTree personalTree = new BinaryTree();

        /* Agregar datos */
        personalTree.add(72, 21, "Carlos Pérez");
        personalTree.add(63, 24, "Armando Hernández");
        personalTree.add(81, 27, "María Pacheco");
        personalTree.add(66, 30, "Enrique Sánchez");
        personalTree.add(75, 33, "Mario Monterroso");
        personalTree.add(84, 36, "Gerson Duarte");
        personalTree.add(45, 39, "Norman López");
        personalTree.add(69, 42, "Rudy Morales");
        personalTree.add(71, 45, "Steed Carpio");

        System.out.print(" Impresion del arbol \n");

        personalTree.printBinaryTree(personalTree.root, 1);

        System.out.print(" Impresion del arbol en pre orden \n");
        personalTree.traversePreOrder(personalTree.root);
        System.out.print("\n");

        /* Eliminar un elemento del arbol */
        personalTree.delete(71);

        System.out.print(" Impresion del arbol en post orden \n");
        personalTree.traversePostOrder(personalTree.root);
        System.out.print("\n");

        personalTree.printBinaryTree(personalTree.root, 1);
    }
}
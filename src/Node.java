public class Node {
    int id, edad;
    String nombre;
    Node leftNode;
    Node rightNode;

    Node(int id, int edad, String nombre) {
        this.id = id;
        this.edad = edad;
        this.nombre = nombre;
        leftNode = null;
        rightNode = null;
    }
}
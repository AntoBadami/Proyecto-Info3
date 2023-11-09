
class NodoAVL {
    Producto element;
    int altura;
    NodoAVL left;
    NodoAVL right;
    int stock;

    public NodoAVL(Producto producto) {
        this.element = producto;
        this.altura = 1;
        left = right = null;
        this.stock = producto.stock;
    }

    public void printInOrder() {
        if (left != null) left.printInOrder();
        System.out.println(element.nombre);
        if (right != null) right.printInOrder();
    }

    public void printPreOrder() {
        System.out.println(element.nombre);
        if (left != null) left.printPreOrder();
        if (right != null) right.printPreOrder();
    }

    public Producto devolverElementos() {
        if (left != null) left.devolverElementos();
        if (right != null) right.devolverElementos();
        return element;
    }
}


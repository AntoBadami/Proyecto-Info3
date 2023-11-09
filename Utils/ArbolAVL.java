
class ArbolAVL {

    protected NodoAVL root;

    public ArbolAVL() {
        root = null;
    }

    public void insert(Producto producto) throws Exception {
        root = insert(producto, root);
    }

    public void remove(String nombre) throws Exception {
        root = remove(nombre, root);
    }

    public void removeMin() throws Exception {
        root = removeMin(root);
    }

    public Producto findMin() {
        return elementAt(findMin(root));
    }

    public Producto findMax() {
        return elementAt(findMax(root));
    }

    public NodoAVL find(String nombre) {
        return find(nombre, root);
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private Producto elementAt(NodoAVL t) {
        return (t == null) ? null : t.element;
    }

    private NodoAVL find(String nombre, NodoAVL t) {
        while (t != null) {
            if (nombre.compareTo(t.element.nombre) < 0) {
                t = t.left;
            } else if (nombre.compareTo(t.element.nombre) > 0) {
                t = t.right;
            } else {
                return t;
            }
        }
        return null;
    }

    private NodoAVL findMin(NodoAVL t) {
        if (t != null) {
            while (t.left != null) {
                t = t.left;
            }
        }
        return t;
    }

    private NodoAVL findMax(NodoAVL t) {
        if (t != null) {
            while (t.right != null) {
                t = t.right;
            }
        }
        return t;
    }

    protected NodoAVL insert(Producto producto, NodoAVL t) throws Exception {
        if (t == null) {
            t = new NodoAVL(producto);
        } else if (producto.nombre.compareTo(t.element.nombre) < 0) {
            t.left = insert(producto, t.left);
        } else if (producto.nombre.compareTo(t.element.nombre) > 0) {
            t.right = insert(producto, t.right);
        } else {
            t.stock = t.stock + producto.stock;
            throw new Exception("Producto duplicado: " + producto.nombre + " - stocks sumados");
        }

        actualizarAltura(t);

        int balance = altura(t.left) - altura(t.right);
        if (balance > 1) {
            if (producto.nombre.compareTo(t.left.element.nombre) < 0) {
                t = rotacionSimpleIzq(t);
            } else {
                t = rotacionDobleIzq(t);
            }
        } else if (balance < -1) {
            if (producto.nombre.compareTo(t.right.element.nombre) > 0) {
                t = rotacionSimpleDer(t);
            } else {
                t = rotacionDobleDer(t);
            }
        }

        return t;
    }

    protected NodoAVL removeMin(NodoAVL t) throws Exception {
        if (t == null) {
            throw new Exception();
        } else if (t.left != null) {
            t.left = removeMin(t.left);
            return t;
        } else {
            return t.right;
        }
    }

    protected NodoAVL remove(String nombre, NodoAVL t) throws Exception {
        if (t == null) {
            throw new Exception(nombre);
        }
        if (nombre.compareTo(t.element.nombre) < 0) {
            t.left = remove(nombre, t.left);
        } else if (nombre.compareTo(t.element.nombre) > 0) {
            t.right = remove(nombre, t.right);
        } else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = removeMin(t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }

    public void printInOrder() {
        if (root != null) root.printInOrder();
    }

    public void printPreOrder() {
        if (root != null) root.printPreOrder();
    }

    public NodoAVL devolver() {
        if (root != null) root.devolverElementos();
        return root;
    }

    public int altura(NodoAVL nodo) {
        if (nodo == null) return 0;
        return nodo.altura;
    }

    public void actualizarAltura(NodoAVL nodo) {
        nodo.altura = 1 + Math.max(altura(nodo.left), altura(nodo.right));
    }

    public NodoAVL rotacionSimpleIzq(NodoAVL k2) {
        NodoAVL k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    public NodoAVL rotacionSimpleDer(NodoAVL k2) {
        NodoAVL k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        return k1;
    }

    public NodoAVL rotacionDobleIzq(NodoAVL k3) {
        k3.left = rotacionSimpleDer(k3.left);
        return rotacionSimpleIzq(k3);
    }

    public NodoAVL rotacionDobleDer(NodoAVL k1) {
        k1.right = rotacionSimpleIzq(k1.right);
        return rotacionSimpleDer(k1);
    }
}
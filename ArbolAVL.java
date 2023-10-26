public class ArbolAVL <AnyType extends Comparable<? super AnyType>> {

    protected NodoAVL<AnyType> root;

    public ArbolAVL(){
        root = null;
    }
    public void insert (AnyType x, int stock) throws Exception{
        root = insert(x, root, stock);
    }
    public void remove (AnyType x) throws Exception{
        root = remove(x, root);
    }
    public void removeMin() throws Exception{
        root = removeMin(root);
    }
    public AnyType findMin(){
        return elementAt(findMin(root));
    }
    public AnyType findMax(){
        return elementAt( findMax(root));
    }
    public NodoAVL<AnyType> find(AnyType x){
        return find(x,root);
    }
    public void makeEmpty(){
        root = null;
    }
    public boolean isEmpty(){
        return root == null;
    }

    private AnyType elementAt(NodoAVL<AnyType> t){
         return (t == null) ? null : t.element;
    }
    private NodoAVL<AnyType> find(AnyType x, NodoAVL<AnyType> t){
        while(t != null){
            if(x.compareTo(t.element) < 0){
                t = t.left;
            }else if(x.compareTo(t.element) > 0){
                t = t.right;
            }else{
                return t;
            }
        }
        return null;
    }
    private NodoAVL<AnyType> findMin(NodoAVL<AnyType> t){
        if(t != null){
            while(t.left != null){
                t = t.left;
            }
        }
        return t;
    }
    private NodoAVL<AnyType> findMax(NodoAVL<AnyType> t){
        if(t != null){
            while(t.right != null){
                t = t.right;
            }
        }
        return t;
    }

    protected NodoAVL<AnyType> insert (AnyType x, NodoAVL<AnyType> t, int stock) throws Exception{
        if(t == null){
            t = new NodoAVL<AnyType>(x, stock);
        }else if(x.compareTo(t.element) < 0){
            t.left = insert(x, t.left, stock);
        }else if(x.compareTo(t.element) > 0){
            t.right = insert(x, t.right, stock);
        }else{
            throw new Exception("Producto duplicado: " +x.toString()); //DuplicateItemException(x.toString());
        }
        
        actualizarAltura(t);// Actualiza la altura del nodo actual

        // Verifica el equilibrio y realiza las rotaciones si es necesario
        int balance = altura(t.left) - altura(t.right);
        if (balance > 1) {
            if (x.compareTo(t.left.element) < 0) {
                // La inserción se realizó en el subárbol izquierdo del subárbol izquierdo
                t = rotacionSimpleIzq(t);
            } else {
                // La inserción se realizó en el subárbol derecho del subárbol izquierdo
                t = rotacionDobleIzq(t);
            }
        } else if (balance < -1) {
            if (x.compareTo(t.right.element) > 0) {
                // La inserción se realizó en el subárbol derecho del subárbol derecho
                t = rotacionSimpleDer(t);
            } else {
                // La inserción se realizó en el subárbol izquierdo del subárbol derecho
                t = rotacionDobleDer(t);
            }
        }

        return t;
    }

    protected NodoAVL<AnyType> removeMin(NodoAVL<AnyType> t) throws Exception{
        if(t == null){
            throw new Exception(); // ItemNotFoundExceptios();
        }else if(t.left != null){
            t.left = removeMin(t.left);
            return t;
        }else{
            return t.right;
        }
    }
    protected NodoAVL<AnyType> remove(AnyType x, NodoAVL<AnyType> t)throws Exception{
        if(t == null){
            throw new Exception(x.toString()); //ItemNotFoundException(x.toString());
        }
        if(x.compareTo(t.element) < 0){
            t.left = remove(x, t.left);
        }else if(x.compareTo(t.element) > 0){
            t.right = remove(x, t.right);
        }else if(t.left != null && t.right != null){
            t.element = findMin(t.right).element;
            t.right = removeMin(t.right);
        }else{
            t = (t.left != null) ? t.left : t.right;
        }
        return t;
    }


    public void printInOrder(){
        if(root != null) root.printInOrder();
    }
    public void printPreOrder(){
        if(root != null) root.printPreOrder();
    }
    
    //metodo para obtener la altura de un nodo
    public int altura (NodoAVL<AnyType> nodo){
        if(nodo == null) return 0;
        return nodo.altura;
    }

    //Metodo para actualizar la altura de un nodo
    public void actualizarAltura(NodoAVL<AnyType> nodo){
        nodo.altura = 1+ Math.max(altura(nodo.left), altura(nodo.right));
    }

    //rotacion simple a la izquierda
    public NodoAVL<AnyType> rotacionSimpleIzq (NodoAVL<AnyType> k2){
        NodoAVL <AnyType> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    //rotacion simple a la derecha
    public NodoAVL<AnyType> rotacionSimpleDer (NodoAVL<AnyType> k2){
        NodoAVL <AnyType> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        return k1;
    }

    //rotacion doble a la izquierda
    public NodoAVL<AnyType> rotacionDobleIzq(NodoAVL<AnyType> k3) {
        k3.left = rotacionSimpleDer(k3.left); // Primero, rotación simple a la derecha en el hijo izquierdo
        return rotacionSimpleIzq(k3); // Luego, rotación simple a la izquierda en el nodo original
    }

    //rotacion doble a la derecha
    public NodoAVL<AnyType> rotacionDobleDer(NodoAVL<AnyType> k1) {
        k1.right = rotacionSimpleIzq(k1.right); // Primero, rotación simple a la izquierda en el hijo derecho
        return rotacionSimpleDer(k1); // Luego, rotación simple a la derecha en el nodo original
    }
}

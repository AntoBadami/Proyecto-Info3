public class NodoAVL <AnyType> {
    AnyType element;
    int altura;
    NodoAVL<AnyType> left;
    NodoAVL <AnyType> right;
    int stock; //stock del producto

    public NodoAVL(AnyType theElement, int stock){
        this.element = theElement;
        this.altura = 1;
        left = right = null;
        this.stock = stock;
    }

    public void printInOrder(){
        if(left != null) left.printInOrder(); //left
        System.out.println(element); //nodo
        if(right != null) right.printInOrder(); //right
    }
    public void printPreOrder(){
        System.out.println(element); //node
        if(left != null) left.printPreOrder(); //left
        if(right != null) right.printPreOrder(); //right
    }

    public AnyType devolverElementos(){
        if(left != null) left.devolverElementos(); //left
        if(right != null) right.devolverElementos(); //right
        return element;//nodo
    }
    
}



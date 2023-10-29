//nodo para la lista
public class Nodo<AnyType> {

  AnyType data;
  Nodo<AnyType> next;
  int stock;

  public Nodo(AnyType data, int stock) {
    this.data = data;
    this.next = null;
    this.stock = stock;
  }

}



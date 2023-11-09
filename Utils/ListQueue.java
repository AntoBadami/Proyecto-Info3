
class ListQueue {
    private Nodo front;
    private Nodo back;

    public ListQueue() {
        front = back = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(Producto producto, int stock) {
        if (isEmpty()) {
            back = front = new Nodo(producto, stock);
        } else {
            back.next = new Nodo(producto, stock);
            back = back.next;
        }
    }

    public Producto dequeue() throws Exception {
        if (isEmpty())
            throw new Exception("ListQueue dequeue");
        Producto returnValue = front.data;
        front = front.next;
        return returnValue;
    }

    public Producto getFront() throws Exception {
        if (isEmpty())
            throw new Exception("ListQueue getFront");
        return front.data;
    }

    public void makeEmpty() {
        front = null;
        back = null;
    }

    public int getStock() {
        return front.stock;
    }
}
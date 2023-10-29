public class ListQueue<AnyType> {
    private Nodo<AnyType> front;
    private Nodo<AnyType> back;

    public ListQueue(){
        front = back = null;
    }
    public boolean isEmpty(){
        return front == null;
    }

    public void enqueue(AnyType x, int stock) {
        if (isEmpty()) {
            back = front = new Nodo<AnyType>(x, stock);
        } else {
            back.next = new Nodo<AnyType>(x, stock);
            back = back.next;
        }
    }
    public AnyType dequeue() throws Exception{
        if(isEmpty())
            throw new Exception("ListQueue dequeue");
        AnyType returnValue = front.data;
        front = front.next;
        return returnValue;
    }

    public AnyType getFront() throws Exception{
        if(isEmpty())
            throw new Exception("ListQueue getFront");
        return front.data;
    }

    public void makeEmpty(){
        front = null;
        back = null;
    }
    public int getStock() {
        return front.stock;
    }

}